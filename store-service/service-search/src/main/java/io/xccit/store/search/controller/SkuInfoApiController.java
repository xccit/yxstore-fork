package io.xccit.store.search.controller;

import io.swagger.annotations.Api;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.search.service.ISkuInfoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-06-16
 * @description
 */
@Api(tags = "商品操作接口")
@RestController
@RequestMapping("/api/search/sku")
public class SkuInfoApiController {

    @Autowired
    private ISkuInfoApiService skuInfoApiService;

    /**
     * 根据SkuID上架
     * @param skuID skuid
     * @return 结果
     */
    @GetMapping("/upperSku/{skuID}")
    public AjaxResult<String> upperSku(@PathVariable Long skuID){
        skuInfoApiService.upperSku(skuID);
        return AjaxResult.ok("成功");
    }

    /**
     * 根据SkuID下架
     * @param skuID skuid
     * @return 结果
     */
    @GetMapping("/lowerSku/{skuID}")
    public AjaxResult<String> lowerSku(@PathVariable Long skuID){
        skuInfoApiService.lower(skuID);
        return AjaxResult.ok("成功");
    }
}
