package io.xccit.store.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.product.service.ISkuInfoService;
import io.xccit.store.vo.product.SkuInfoQueryVo;
import io.xccit.store.vo.product.SkuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */

@Api(tags = "SKU接口")
@RestController
@RequestMapping("/admin/product/skuInfo")
@CrossOrigin
public class SkuInfoController {

    @Autowired
    private ISkuInfoService skuInfoService;

    @ApiOperation("SKU分页查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<SkuInfo>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                  @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
                                                  @ApiParam("条件查询对象")SkuInfoQueryVo skuInfoQueryVo){
        Page<SkuInfo> skuInfoPage = new Page<>(pageNo, pageSize);
        IPage<SkuInfo> pageModel = skuInfoService.getPageList(skuInfoPage,skuInfoQueryVo);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("添加SKU")
    @PostMapping("/save")
    public AjaxResult<String> saveSkuInfo(@ApiParam(value = "商品信息Vo",required = true) @RequestBody SkuInfoVo skuInfoVo){
        skuInfoService.saveSkuInfo(skuInfoVo);
        return AjaxResult.ok("添加成功");
    }
}

