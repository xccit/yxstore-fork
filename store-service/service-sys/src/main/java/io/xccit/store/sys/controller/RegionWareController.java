package io.xccit.store.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.sys.RegionWare;
import io.xccit.store.sys.service.IRegionWareService;
import io.xccit.store.vo.sys.RegionWareQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

/**
 * <p>
 * 城市仓库关联表 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Api(tags = "开通区域接口")
@RestController
@RequestMapping("/admin/sys/regionWare")
@CrossOrigin
public class RegionWareController {

    @Autowired
    private IRegionWareService regionWareService;

    @ApiOperation("开通区域列表")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<RegionWare>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                     @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
                                                     @ApiParam("条件查询请求体")RegionWareQueryVo regionWare){
        Page<RegionWare> regionWarePage = new Page<>(pageNo, pageSize);
        IPage<RegionWare> resultPage = regionWareService.getPageList(regionWarePage,regionWare);
        return AjaxResult.ok(resultPage);
    }

    @ApiOperation("添加开通区域")
    @PostMapping("/save")
    public AjaxResult<String> openRegionWare(@ApiParam(value = "区域仓库请求体",required = true) @RequestBody RegionWare regionWare){
        regionWareService.openRegionWare(regionWare);
        return AjaxResult.ok("开通成功");
    }

    @ApiOperation("删除开通区域")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<Boolean> deleteRegionWare(@PathVariable("id") Long id){
        return AjaxResult.ok(regionWareService.removeById(id));
    }

    @ApiOperation("取消开通区域")
    @PostMapping("/updateStatus/{id}/{status}")
    public AjaxResult<Boolean> cancelRegionWare(@ApiParam(value = "区域仓库ID",required = true) @PathVariable Long id,
                                       @ApiParam(value = "区域仓库状态",required = true) @PathVariable Integer status){

        return AjaxResult.ok(regionWareService.updateStatus(id,status));
    }
}

