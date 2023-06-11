package io.xccit.store.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.acl.service.IAdminService;
import io.xccit.store.acl.service.IRoleService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.acl.Admin;
import io.xccit.store.common.utils.MD5;
import io.xccit.store.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description 用户控制层
 */

@Api(tags = "用户接口")
@RestController
@CrossOrigin
@RequestMapping("/admin/acl/user")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;

/*    @ApiOperation("用户登录")
    public AjaxResult<> login(){

    }*/


    @ApiOperation("查询角色列表及根据用户ID获取用户已分配角色")
    @GetMapping("/toAssign/{adminID}")
    public AjaxResult<Map<String,Object>> toAssign(@ApiParam(value = "用户ID",required = true) @PathVariable Long adminID){
        /*map中包含两部分数据:1.角色列表 2.用户已分配角色列表*/
        Map<String,Object> roleAndAdminRole = roleService.getListByAdminID(adminID);
        return AjaxResult.ok(roleAndAdminRole);
    }

    @ApiOperation("用户分页条件查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<Admin>> getAdminPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                     @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
                                                     @ApiParam("用户查询条件请求体") AdminQueryVo adminQueryVo){
        Page<Admin> adminPage = new Page<>(pageNo, pageSize);
        IPage<Admin> pageModel = adminService.getAdminPageList(adminPage,adminQueryVo);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("根据ID获取用户")
    @GetMapping("/get/{id}")
    public AjaxResult<Admin> getAdminByID(@ApiParam(value = "用户ID",required = true) @PathVariable Long id){
        return AjaxResult.ok(adminService.getById(id));
    }

    @ApiOperation("用户添加")
    @PostMapping("/save")
    public AjaxResult<String> saveAdmin(@ApiParam(value = "用户请求体",required = true) @RequestBody Admin admin){
        String md5Password = MD5.encrypt(admin.getPassword()); //加密
        admin.setPassword(md5Password); //设置加密后的值
        boolean saved = adminService.save(admin);
        if (saved){
            return AjaxResult.ok("添加成功");
        }else{
            return AjaxResult.fail("添加失败");
        }
    }

    @ApiOperation("修改用户")
    @PutMapping("/update")
    public AjaxResult<String> updateAdmin(@ApiParam(value = "修改用户请求体",required = true) @RequestBody Admin admin){
        boolean updated = adminService.updateById(admin);
        if (updated){
            return AjaxResult.ok("更新成功");
        }else{
            return AjaxResult.fail("更新失败");
        }
    }

    @ApiOperation("根据ID删除用户")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<String> deleteByID(@ApiParam(value = "用户ID",required = true) @PathVariable Long id){
        adminService.removeById(id);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping("/batchRemove")
    public AjaxResult<String> removeBatch(@ApiParam(value = "用户ID列表",required = true) @RequestBody List<Long> ids){
        if (adminService.removeBatchByIds(ids)){
            return AjaxResult.ok("删除成功");
        }else{
            return AjaxResult.fail("删除失败");
        }
    }
}
