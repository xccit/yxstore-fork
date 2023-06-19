package io.xccit.store.acl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.common.result.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description 用户接口
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/admin/acl/index")
//@CrossOrigin
public class IndexController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AjaxResult<Map<String,Object>> login(){
        Map<String,Object> map = new HashMap<>();
        map.put("token","token-admin");
        return AjaxResult.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public AjaxResult<Map<String,Object>> getInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","admin");
        map.put("avatar","https://t7.baidu.com/it/u=848096684,3883475370&fm=193&f=GIF");
        return AjaxResult.ok(map);
    }

    @ApiOperation("用户退出")
    @PostMapping("/logout")
    public AjaxResult<Object> logout(){
        return AjaxResult.ok(null);
    }
}
