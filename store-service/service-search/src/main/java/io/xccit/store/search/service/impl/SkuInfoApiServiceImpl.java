package io.xccit.store.search.service.impl;

import io.xccit.store.client.product.ProductFeignClient;
import io.xccit.store.common.exception.StoreException;
import io.xccit.store.common.result.ResultCodeEnum;
import io.xccit.store.enums.SkuType;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.model.search.SkuEs;
import io.xccit.store.search.repository.SkuInfoRepository;
import io.xccit.store.search.service.ISkuInfoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-16
 * @description
 */
@Service
public class SkuInfoApiServiceImpl implements ISkuInfoApiService {

    @Autowired
    private SkuInfoRepository skuInfoRepository;
    @Autowired
    private ProductFeignClient productFeignClient;

    /**
     * 商品上架
     * @param skuID skuid
     */
    @Override
    public void upperSku(Long skuID) {
        SkuInfo skuInfo = productFeignClient.getSkuBySkuID(skuID);
        Category category = productFeignClient.getCategoryByID(skuInfo.getCategoryId());
        SkuEs skuEs = new SkuEs();
        if (skuInfo == null){
            throw new StoreException(ResultCodeEnum.DATA_ERROR);
        }
        //封装分类部分
        if (category != null){
            skuEs.setCategoryId(category.getId());
            skuEs.setCategoryName(category.getName());
        }
        //封装商品部分
        skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName()+","+skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if(skuInfo.getSkuType() == SkuType.COMMON.getCode()) {
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getStock());
            skuEs.setSale(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());
        } else {
            //TODO 待完善-秒杀商品
        }
        //保存到ES
        skuInfoRepository.save(skuEs);
    }

    /**
     * 根据SkuID下架
     * @param skuID skuid
     */
    @Override
    public void lower(Long skuID) {
        skuInfoRepository.deleteById(skuID);
    }
}
