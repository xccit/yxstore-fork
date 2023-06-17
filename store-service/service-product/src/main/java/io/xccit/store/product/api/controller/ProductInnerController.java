package io.xccit.store.product.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.product.service.ICategoryService;
import io.xccit.store.product.service.ISkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description
 */
@Api(tags = "商品内部调用接口")
@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductInnerController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISkuInfoService skuInfoService;

    @ApiOperation("根据商品分类ID获取商品分类")
    @GetMapping("/inner/getCategory/{cateGoryID}")
    public Category getCategoryByID(@PathVariable Long cateGoryID){
        return categoryService.getById(cateGoryID);
    }

    @ApiOperation("根据SkuID获取SKU")
    @GetMapping("/inner/getSkuInfo/{skuID}")
    public SkuInfo getSkuBySkuID(@PathVariable Long skuID){
        return skuInfoService.getById(skuID);
    }
}
