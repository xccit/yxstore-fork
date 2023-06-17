package io.xccit.store.client.product;

import io.swagger.annotations.ApiOperation;
import io.xccit.store.model.product.Category;
import io.xccit.store.model.product.SkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
