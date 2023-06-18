package io.xccit.store.product.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.License;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.product.service.ICategoryService;
import io.xccit.store.product.service.ISkuInfoService;
import io.xccit.store.vo.activity.ActivityRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description
 */
@Api(tags = "商品远程调用接口")
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
    public SkuInfo getSkuBySkuID(@ApiParam(value = "skuID",required = true) @PathVariable Long skuID){
        return skuInfoService.getById(skuID);
    }

    @ApiOperation("根据SkuID列表获取SkuInfo")
    @PostMapping("/inner/findSkuInfoList")
    public List<SkuInfo> getSkuInfoListByIDS(@ApiParam(value = "skuID列表",required = true) @RequestBody List<Long> skuIds){
        return skuInfoService.getSkuInfoListByIDS(skuIds);
    }

    @ApiOperation("根据关键字查找SKU")
    @GetMapping("/inner/findSkuInfoByKeyword/{keyword}")
    public List<SkuInfo> findSkuInfoByKeyword(@PathVariable String keyword){
        return skuInfoService.findSkuInfoByKeyword(keyword);
    }

}
