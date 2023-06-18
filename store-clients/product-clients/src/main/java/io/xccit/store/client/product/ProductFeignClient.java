package io.xccit.store.client.product;

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

    @GetMapping("/api/product/inner/getCategory/{cateGoryID}")
    public Category getCategoryByID(@PathVariable("cateGoryID") Long cateGoryID);

    @GetMapping("/api/product/inner/getSkuInfo/{skuID}")
    public SkuInfo getSkuBySkuID(@PathVariable("skuID") Long skuID);
    @PostMapping("/api/product/inner/findSkuInfoList")
    public List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIds);

    @GetMapping("/api/product/inner/findSkuInfoByKeyword/{keyword}")
    public List<SkuInfo> findSkuInfoByKeyword(@PathVariable String keyword);
}
