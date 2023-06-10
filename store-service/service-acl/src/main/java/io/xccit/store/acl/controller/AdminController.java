package io.xccit.store.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.acl.service.IAdminService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.acl.Admin;
import io.xccit.store.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

/*    @ApiOperation("用户登录")
    public AjaxResult<> login(){

    }*/

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
        boolean saved = adminService.save(admin);
        if (saved){
            return AjaxResult.ok("添加成功");
        }else{
            return AjaxResult.fail("添加失败");
        }
    }
}
