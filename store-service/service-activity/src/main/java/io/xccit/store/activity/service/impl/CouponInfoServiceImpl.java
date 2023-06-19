package io.xccit.store.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.activity.mapper.CouponInfoMapper;
import io.xccit.store.activity.mapper.CouponRangeMapper;
import io.xccit.store.activity.service.ICouponInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.client.product.ProductFeignClient;
import io.xccit.store.enums.CouponRangeType;
import io.xccit.store.model.activity.CouponInfo;
import io.xccit.store.model.activity.CouponRange;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.vo.activity.CouponRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements ICouponInfoService {


    @Autowired
    private CouponInfoMapper couponInfoMapper;
    @Autowired
    private CouponRangeMapper couponRangeMapper;
    @Autowired
    private ProductFeignClient productFeignClient;

    /**
     * 获取分页数据
     * @param couponInfoPage 分页信息
     */
    @Override
    public IPage<CouponInfo> getPageList(Page<CouponInfo> couponInfoPage) {
        Page<CouponInfo> page = couponInfoMapper.selectPage(couponInfoPage, null);
        List<CouponInfo> couponInfos = page.getRecords();
        couponInfos.stream().forEach(couponInfo -> {
            couponInfo.setCouponTypeString(couponInfo.getCouponType().getComment());
            if (couponInfo.getRangeType() != null){
                couponInfo.setRangeTypeString(couponInfo.getRangeType().getComment());
            }
        });
        return page;
    }

    /**
     * 根据ID获取
     * @param couponID
     * @return
     */
    @Override
    public CouponInfo getCouponInfoByID(Long couponID) {
        CouponInfo couponInfo = couponInfoMapper.selectById(couponID);
        couponInfo.setCouponTypeString(couponInfo.getCouponType().getComment());
        if (couponInfo.getRangeType() != null){
            couponInfo.setRangeTypeString(couponInfo.getRangeType().getComment());
        }
        return couponInfo;
    }

    /**
     * 根据优惠券ID获取优惠券规则数据
     * @param couponID 优惠券ID
     * @return 规则数据
     */
    @Override
    public Map<String, Object> getCouponRegByID(Long couponID) {
        Map<String,Object> result = new HashMap<>();
        CouponInfo couponInfo = couponInfoMapper.selectById(couponID);
        LambdaQueryWrapper<CouponRange> rangeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rangeLambdaQueryWrapper.eq(CouponRange::getCouponId,couponID);
        //根据couponID查询到的Coupon列表
        List<CouponRange> couponRangeList = couponRangeMapper.selectList(rangeLambdaQueryWrapper);
        // range_id列表
        List<Long> rangeIDList = couponRangeList.stream().map(CouponRange::getRangeId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(rangeIDList)){
            //根据类型查询相应的range_id(sku_id 或 category_id)
            if (couponInfo.getRangeType() == CouponRangeType.SKU){
                //获取的SKU列表
                List<SkuInfo> skuInfoList = productFeignClient.findSkuInfoList(rangeIDList);
                result.put("skuInfoList",skuInfoList);
            }else if (couponInfo.getRangeType() == CouponRangeType.CATEGORY){
                List<Category> selectCategoryList = productFeignClient.findCateGoryList(rangeIDList);
                result.put("selectCategoryList",selectCategoryList);
            }
        }
        return result;
    }

    /**
     * 添加优惠券规则数据
     * @param couponRuleVo
     */
    @Override
    public void saveCouponReg(CouponRuleVo couponRuleVo) {
        //根据优惠券ID获取优惠券信息
        Long couponId = couponRuleVo.getCouponId();
        CouponInfo couponInfo = couponInfoMapper.selectById(couponId);
        //删除旧的优惠券规则信息
        LambdaQueryWrapper<CouponRange> rangeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rangeLambdaQueryWrapper.eq(CouponRange::getCouponId,couponId);
        couponRangeMapper.delete(rangeLambdaQueryWrapper);
        //更新优惠券基本信息
        couponInfo.setRangeType(couponRuleVo.getRangeType());
        couponInfo.setRangeDesc(couponRuleVo.getRangeDesc());
        couponInfo.setConditionAmount(couponRuleVo.getConditionAmount());
        couponInfo.setAmount(couponRuleVo.getAmount());
        couponInfoMapper.updateById(couponInfo);
        //添加优惠券规则信息
        List<CouponRange> couponRangeList = couponRuleVo.getCouponRangeList();
        for (CouponRange couponRange : couponRangeList) {
            couponRange.setCouponId(couponId);
            couponRangeMapper.insert(couponRange);
        }
    }

}
