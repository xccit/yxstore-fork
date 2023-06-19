package io.xccit.store.activity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.activity.mapper.ActivityInfoMapper;
import io.xccit.store.activity.mapper.ActivityRuleMapper;
import io.xccit.store.activity.mapper.ActivitySkuMapper;
import io.xccit.store.activity.service.IActivityInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.client.product.ProductFeignClient;
import io.xccit.store.model.activity.ActivityInfo;
import io.xccit.store.model.activity.ActivityRule;
import io.xccit.store.model.activity.ActivitySku;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.vo.activity.ActivityRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Service
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfo> implements IActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;
    @Autowired
    private ActivityRuleMapper activityRuleMapper;
    @Autowired
    private ActivitySkuMapper activitySkuMapper;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Override
    public IPage<ActivityInfo> getPageList(Page<ActivityInfo> activityInfoPage) {
        IPage<ActivityInfo> page = activityInfoMapper.selectPage(activityInfoPage, null);
        page.getRecords().stream().forEach(item -> {
            item.setActivityTypeString(item.getActivityType().getComment());
        });
        return page;
    }

    /**
     * 根据活动ID获取活动规则及SKU列表
     * @param activityID 活动ID
     * @return 活动规则及SKU列表
     */
    @Override
    public Map<String, Object> findActivityRuleList(Long activityID) {
        Map<String,Object> result = new HashMap<>();
        //查询活动规则 activity_rule表
        LambdaQueryWrapper<ActivityRule> ruleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ruleLambdaQueryWrapper.eq(ActivityRule::getActivityId,activityID);
        List<ActivityRule> activityRules = activityRuleMapper.selectList(ruleLambdaQueryWrapper);
        if (activityRules.size() == 0){
            result.put("activityRuleList",new ArrayList<ActivityRule>());
        }
        result.put("activityRuleList",activityRules);
        //查询活动SKU 根据activity_sku表中的activity_id 匹配 sku_id列表 根据sku_id 列表 查询 sku_info(product)-->远程调用
        LambdaQueryWrapper<ActivitySku> skuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        skuLambdaQueryWrapper.eq(ActivitySku::getActivityId,activityID);
        List<ActivitySku> activitySkus = activitySkuMapper.selectList(skuLambdaQueryWrapper);
        //获取activity_sku表中的sku_id
        List<Long> skuIds = activitySkus.stream().map(ActivitySku::getSkuId).collect(Collectors.toList());
        //远程调用 通过skuIds 获取 sku_info
        List<SkuInfo> skuInfoList = productFeignClient.findSkuInfoList(skuIds);
        if (skuInfoList.size() == 0){
            result.put("skuInfoList",new ArrayList<SkuInfo>());
        }
        result.put("skuInfoList",skuInfoList);
        return result;
    }

    /**
     * 添加活动规则数据(删除旧的,添加新的)
     * @param activityRuleVo 活动规则Vo
     */
    @Override
    public void saveActivityRuleAndSku(ActivityRuleVo activityRuleVo) {
        // 请求体活动ID
        Long activityId = activityRuleVo.getActivityId();
        // 请求体活动规则列表
        List<ActivityRule> activityRuleList = activityRuleVo.getActivityRuleList();
        // 请求体活动商品列表
        List<ActivitySku> activitySkuList = activityRuleVo.getActivitySkuList();
        // 根据请求体活动ID查出的活动
        ActivityInfo activityInfo = activityInfoMapper.selectById(activityId);
        //删除旧的
        LambdaQueryWrapper<ActivityRule> ruleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ruleLambdaQueryWrapper.eq(ActivityRule::getActivityId,activityId);
        activityRuleMapper.delete(ruleLambdaQueryWrapper);
        LambdaQueryWrapper<ActivitySku> skuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        skuLambdaQueryWrapper.eq(ActivitySku::getActivityId,activityId);
        activitySkuMapper.delete(skuLambdaQueryWrapper);
        //添加新的
        for (ActivityRule activityRule : activityRuleList) {
            activityRule.setActivityId(activityId);
            activityRule.setActivityType(activityInfo.getActivityType());
            activityRuleMapper.insert(activityRule);
        }
        for (ActivitySku activitySku : activitySkuList) {
            activitySku.setActivityId(activityId);
            activitySkuMapper.insert(activitySku);
        }
    }

    /**
     * 根据关键字查询活动规则商品
     * @param keyword 关键字
     * @return skuList
     */
    @Override
    public List<SkuInfo> getSkuInfoByKeyword(String keyword) {
        // 远程调用product 根据关键字获取sku列表
        List<SkuInfo> skuInfoList = productFeignClient.findSkuInfoByKeyword(keyword);
        if (skuInfoList.size() == 0){ //如果根据关键字没有查到商品信息,直接返回一个空集合
            return skuInfoList;
        }
        List<Long> skuIDList = skuInfoList.stream().map(SkuInfo::getId).collect(Collectors.toList());
        // 查询activity_info和activity_sku,判断商品列表中的商品是否有参加过活动的,活动未过期且参加过则排除
        // 1.从所有skuID中查询activity_sku表中已参加活动且未过期的id
        List<Long> existsSkuID = activityInfoMapper.selectExistsSkuID(skuIDList);
        // 2.排除已参加活动且活动未过期的商品
        List<SkuInfo> finalSkuInfoList = new ArrayList<>(); //最终商品信息列表
        for (SkuInfo skuInfo : skuInfoList) {
            if (!existsSkuID.contains(skuInfo.getId())){ //skuID在已参加过活动的列表中不存在,封装到最终商品信息集合
                finalSkuInfoList.add(skuInfo);
            }
        }
        return finalSkuInfoList;
    }
}
