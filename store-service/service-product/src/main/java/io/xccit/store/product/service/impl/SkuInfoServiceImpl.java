package io.xccit.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.model.product.SkuAttrValue;
import io.xccit.store.model.product.SkuImage;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.model.product.SkuPoster;
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
}
