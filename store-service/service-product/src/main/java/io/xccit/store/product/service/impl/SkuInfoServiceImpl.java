package io.xccit.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.model.product.SkuAttrValue;
import io.xccit.store.model.product.SkuImage;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.model.product.SkuPoster;
import io.xccit.store.mq.constant.MQConst;
import io.xccit.store.mq.service.RabbitService;
import io.xccit.store.product.mapper.SkuInfoMapper;
import io.xccit.store.product.service.ISkuAttrValueService;
import io.xccit.store.product.service.ISkuImageService;
import io.xccit.store.product.service.ISkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.product.service.ISkuPosterService;
import io.xccit.store.vo.product.SkuInfoQueryVo;
import io.xccit.store.vo.product.SkuInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements ISkuInfoService {

    @Autowired
    private SkuInfoMapper skuInfoMapper;

    @Autowired
    private ISkuPosterService skuPosterService;

    @Autowired
    private ISkuImageService skuImageService;

    @Autowired
    private ISkuAttrValueService skuAttrValueService;

    @Autowired
    private RabbitService rabbitService;


    /**
     *
     * @param skuInfoPage 分页条件
     * @param skuInfoQueryVo SkuInfo查询对象
     * @return 分页数据
     */
    @Override
    public IPage<SkuInfo> getPageList(Page<SkuInfo> skuInfoPage, SkuInfoQueryVo skuInfoQueryVo) {
        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
        String skuType = skuInfoQueryVo.getSkuType();
        String keyword = skuInfoQueryVo.getKeyword();
        Long categoryId = skuInfoQueryVo.getCategoryId();
        if (!StringUtils.isEmpty(skuType)){
            wrapper.eq(SkuInfo::getSkuType,skuType);
        }
        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(SkuInfo::getSkuName,keyword);
        }
        if (categoryId != null){
            wrapper.eq(SkuInfo::getCategoryId,categoryId);
        }
        return skuInfoMapper.selectPage(skuInfoPage,wrapper);
    }

    /**
     *
     * @param skuInfoVo SkuInfoVo
     */
    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {
        SkuInfo skuInfo = new SkuInfo();
        //添加基本商品信息到SkuInfo
        BeanUtils.copyProperties(skuInfoVo,skuInfo);
        skuInfoMapper.insert(skuInfo);
        //添加sku海报
        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if (!CollectionUtils.isEmpty(skuPosterList)){ //海报不为空时
            //每个海报都设置上面skuInfo的ID
            for (SkuPoster skuPoster : skuPosterList) {
                skuPoster.setSkuId(skuInfo.getId());
            }
            skuPosterService.saveBatch(skuPosterList);
        }
        //添加sku图片
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if (!CollectionUtils.isEmpty(skuImagesList)){
            for (SkuImage skuImage : skuImagesList) {
                skuImage.setSkuId(skuInfo.getId());
            }
            skuImageService.saveBatch(skuImagesList);
        }
        //添加sku平台
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if (!CollectionUtils.isEmpty(skuAttrValueList)){
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfo.getId());
            }
            skuAttrValueService.saveBatch(skuAttrValueList);
        }
    }

    @Override
    public SkuInfoVo getSkuInfoByID(Long id) {
        SkuInfoVo skuInfoVo = new SkuInfoVo();
        //查询基础的SkuInfo
        SkuInfo skuInfo = skuInfoMapper.selectById(id);
        BeanUtils.copyProperties(skuInfo,skuInfoVo);
        //查询SkuImage
        List<SkuImage> skuImageList = skuImageService.getListBySkuInfoID(id);
        skuInfoVo.setSkuImagesList(skuImageList);
        //查询SkuPoster
        List<SkuPoster> skuPosterList = skuPosterService.getListBySkuID(id);
        skuInfoVo.setSkuPosterList(skuPosterList);
        //查询SkuAttrValue
        List<SkuAttrValue> skuAttrValueList = skuAttrValueService.getListByID(id);
        skuInfoVo.setSkuAttrValueList(skuAttrValueList);
        return skuInfoVo;
    }

    @Override
    public void updateBySkuID(SkuInfoVo skuInfoVo) {
        //修改SkuInfo
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo,skuInfo);
        skuInfoMapper.updateById(skuInfo);
        //修改SkuImage 删除旧的,保存新的
        List<SkuImage> newSkuImageList = skuInfoVo.getSkuImagesList();
        List<SkuImage> oldSkuImageList = skuImageService.getListBySkuInfoID(skuInfo.getId());
        for (SkuImage skuImage : oldSkuImageList) {
            skuImageService.removeById(skuImage);
        }
        for (SkuImage skuImage : newSkuImageList) {
            skuImage.setSkuId(skuInfo.getId());
            skuImageService.save(skuImage);
        }
        //修改SkuPoster
        List<SkuPoster> newSkuPosterList = skuInfoVo.getSkuPosterList();
        List<SkuPoster> oldSkuPosterList = skuPosterService.getListBySkuID(skuInfo.getId());
        for (SkuPoster skuPoster : oldSkuPosterList) {
            skuPosterService.removeById(skuPoster);
        }
        for (SkuPoster skuPoster : newSkuPosterList) {
            skuPoster.setSkuId(skuInfo.getId());
            skuPosterService.save(skuPoster);
        }
        List<SkuAttrValue> newSkuAttrValueList = skuInfoVo.getSkuAttrValueList();
        List<SkuAttrValue> oldSkuAttrValue = skuAttrValueService.getListBySkuID(skuInfo.getId());
        for (SkuAttrValue skuAttrValue : oldSkuAttrValue) {
            skuAttrValueService.removeById(skuAttrValue);
        }
        for (SkuAttrValue skuAttrValue : newSkuAttrValueList) {
            skuAttrValue.setSkuId(skuInfo.getId());
            skuAttrValueService.save(skuAttrValue);
        }
    }

    @Override
    public SkuInfo check(Long skuID, Integer status) {
        SkuInfo skuInfo = skuInfoMapper.selectById(skuID);
        skuInfo.setCheckStatus(status);
        skuInfoMapper.updateById(skuInfo);
        return skuInfo;
    }

    /**
     * 商品上下架
     * @param skuID skuID
     * @param status 上下架状态
     * @return Sku
     */
    @Override
    public SkuInfo publish(Long skuID, Integer status) {
        if (status == 1){ //上架
            SkuInfo skuInfo = skuInfoMapper.selectById(skuID);
            skuInfo.setPublishStatus(1);
            skuInfoMapper.updateById(skuInfo);
            // 整合MQ把数据同步到ES--->发送消息
            rabbitService.sendMessage(MQConst.EXCHANGE_GOODS_DIRECT,
                                      MQConst.ROUTING_GOODS_UPPER,
                                      skuID);
            return skuInfo;
        }else{ //下架
            SkuInfo skuInfo = skuInfoMapper.selectById(skuID);
            skuInfo.setPublishStatus(0);
            skuInfoMapper.updateById(skuInfo);
            //整合MQ把数据同步到ES--->发送消息
            rabbitService.sendMessage(MQConst.EXCHANGE_GOODS_DIRECT,
                                        MQConst.ROUTING_GOODS_LOWER,
                                        skuID);
            return skuInfo;
        }
    }

    @Override
    public SkuInfo isNewPerson(Long skuID, Integer status) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setId(skuID);
        skuInfo.setIsNewPerson(status);
        skuInfoMapper.updateById(skuInfo);
        return skuInfo;
    }

}
