package io.xccit.store.acl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.acl.service.IPermissionService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.acl.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-06-12
 * @description
 */

@Api(tags = "权限/菜单管理")
@RestController
@RequestMapping("/admin/acl/permission")
@CrossOrigin
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @ApiOperation("获取权限/菜单列表")
    @GetMapping
    public AjaxResult list(){
        List<Permission> permissionList = permissionService.getPermissionList();
        return AjaxResult.ok(permissionList);
    }

    @ApiOperation("添加菜单")
    @PostMapping("/save")
    public AjaxResult<Boolean> savePermission(@ApiParam(value = "添加菜单请求体",required = true) @RequestBody Permission permission){
        return AjaxResult.ok(permissionService.save(permission));
    }

    @ApiOperation("修改菜单")
    @PutMapping("/update")
    public AjaxResult<Boolean> updatePermission(@ApiParam(value = "更新菜单请求体",required = true) @RequestBody Permission permission){
        return AjaxResult.ok(permissionService.updateById(permission));
    }

    @ApiOperation("删除/递归删除菜单")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<Boolean> deletePermission(@ApiParam(value = "权限/菜单ID",required = true) @PathVariable Long id){
        permissionService.removeChildByID(id);
        return AjaxResult.ok(null);
    }
}
