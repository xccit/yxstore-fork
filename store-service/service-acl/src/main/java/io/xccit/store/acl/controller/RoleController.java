package io.xccit.store.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.acl.service.IRoleService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.acl.Role;
import io.xccit.store.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation("用户角色分页条件查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<Role>> getRolePageList(
            @ApiParam("当前页") @PathVariable Long pageNo,
            @ApiParam("每页条数") @PathVariable Long pageSize,
            RoleQueryVo roleQueryVo
            ){
        Page<Role> rolePage = new Page<>(pageNo,pageSize);
        IPage<Role> pageModel = roleService.getRolePageList(rolePage,roleQueryVo);
        return AjaxResult.ok(pageModel);
    }
}
