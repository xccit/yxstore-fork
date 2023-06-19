package io.xccit.store.client.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description
 */
@FeignClient(value = "service-product")
public interface ProductFeignClient {

    /**
     * @ApiOperation("根据分类ID查询分类")
     * @param cateGoryID
     * @return
     */
    @GetMapping("/api/product/inner/getCategory/{cateGoryID}")
    public Category getCategoryByID(@PathVariable("cateGoryID") Long cateGoryID);

    /**
     * @ApiOperation("根据skuID查询sku")
     * @param skuID
     * @return
     */
    @GetMapping("/api/product/inner/getSkuInfo/{skuID}")
    public SkuInfo getSkuBySkuID(@PathVariable("skuID") Long skuID);

    /**
     * @ApiOperation("根据SkuID列表查询Sku列表")
     * @param skuIds
     * @return
     */
    @PostMapping("/api/product/inner/findSkuInfoList")
    public List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIds);

    /**
     * @ApiOperation("根据关键字查询Sku")
     * @param keyword
     * @return
     */
    @GetMapping("/api/product/inner/findSkuInfoByKeyword/{keyword}")
    public List<SkuInfo> findSkuInfoByKeyword(@PathVariable String keyword);

    /**
     * @ApiOperation("根据分类ID列表查询分类列表")
     * @param categoryIds
     * @return
     */
    @GetMapping("/api/product/inner/findCategoryList/{categoryIds}")
    List<Category> findCateGoryList(@PathVariable List<Long> categoryIds);
}
