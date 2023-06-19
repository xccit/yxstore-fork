package io.xccit.store.sys.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.sys.Region;
import io.xccit.store.sys.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */

@Api(tags = "区域接口")
@RestController
@RequestMapping("/admin/sys/region")
//@CrossOrigin
public class RegionController {

    @Autowired
    private IRegionService regionService;
    @ApiOperation("根据区域关键字查询区域信息")
    @GetMapping("/findRegionByKeyword/{keyword}")
    public AjaxResult<List<Region>> findRegionByKeyword(@PathVariable String keyword){
        List<Region> regions = regionService.findRegionByKeyword(keyword);
        return AjaxResult.ok(regions);
    }
}

