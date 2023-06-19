package io.xccit.store.sys.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.sys.Ware;
import io.xccit.store.sys.service.IWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 仓库表 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */

@Api(tags = "仓库接口")
@RestController
@RequestMapping("/admin/sys/ware")
//@CrossOrigin
public class WareController {

    @Autowired
    private IWareService wareService;

    @ApiOperation("获取所有仓库")
    @GetMapping("/findAllList")
    public AjaxResult<List<Ware>> findAllList(){
        List<Ware> wares = wareService.list();
        return AjaxResult.ok(wares);
    }
}

