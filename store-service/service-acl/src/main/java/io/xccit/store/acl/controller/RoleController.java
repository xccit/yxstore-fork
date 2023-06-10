package io.xccit.store.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.acl.service.IRoleService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.acl.Role;
import io.xccit.store.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
            @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
            @ApiParam(value = "条件查询对象",required = false) RoleQueryVo roleQueryVo
            ){
        Page<Role> rolePage = new Page<>(pageNo,pageSize);
        IPage<Role> pageModel = roleService.getRolePageList(rolePage,roleQueryVo);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("根据ID获取角色")
    @GetMapping("/get/{id}")
    public AjaxResult<Role> getRoleByID(@ApiParam(value = "角色ID",required = true) @PathVariable Long id){
        Role role = roleService.getById(id);
        return AjaxResult.ok(role);
    }

    @ApiOperation("角色添加")
    @PostMapping("/save")
    public AjaxResult<String> saveRole(@ApiParam(value = "角色信息",required = true) @RequestBody Role role){
        boolean save = roleService.save(role);
        if(save){
            return AjaxResult.ok("添加成功");
        }else {
            return AjaxResult.fail("添加失败");
        }
    }

    @ApiOperation("角色更新")
    @PutMapping("/update")
    public AjaxResult<String> updateRole(@ApiParam("角色信息") @RequestBody Role role){
        boolean updated = roleService.updateById(role);
        if (updated) {
            return AjaxResult.ok("更新成功");
        }else{
            return AjaxResult.fail("更新失败");
        }
    }

    @ApiOperation("角色删除")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<String> deleteRoleByID(@ApiParam(value = "角色ID",required = true) @PathVariable Long id){
        boolean removed = roleService.removeById(id);
        if (removed){
            return AjaxResult.ok("删除成功");
        }else{
            return AjaxResult.fail("删除失败");
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public AjaxResult<String> deleteBatch(@ApiParam(value = "角色ID集合",required = true) @RequestBody List<Long> ids){
        boolean removed = roleService.removeBatchByIds(ids);
        if (removed){
            return AjaxResult.ok("删除成功");
        }else{
            return AjaxResult.fail("删除失败");
        }
    }
}
