package io.xccit.store.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.product.Attr;
import io.xccit.store.product.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */

@Api(tags = "平台属性接口")
@RestController
@RequestMapping("/admin/product/attr")
//@CrossOrigin
public class AttrController {

    @Autowired
    private IAttrService attrService;
    @ApiOperation("根据分组ID获取属性列表")
    @GetMapping("/{groupID}")
    public AjaxResult<List<Attr>> getListByID(@ApiParam(value = "分组ID",required = true) @PathVariable Long groupID){
        QueryWrapper<Attr> attrQueryWrapper = new QueryWrapper<>();
        attrQueryWrapper.eq("attr_group_id",groupID);
        return AjaxResult.ok(attrService.list(attrQueryWrapper));
    }

    @ApiOperation("根据ID获取平台属性")
    @GetMapping("/get/{id}")
    public AjaxResult<Attr> getAttrByID(@ApiParam(value = "属性ID",required = true) @PathVariable Long id){
        return AjaxResult.ok(attrService.getById(id));
    }

    @ApiOperation("添加属性")
    @PostMapping("/save")
    public AjaxResult<String> saveAttr(@ApiParam(value = "平台属性",required = true) @RequestBody Attr attr){
        attrService.save(attr);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("根据ID修改属性")
    @PutMapping("/update")
    public AjaxResult<String> updateAttrByID(@ApiParam(value = "平台属性",required = true) @RequestBody Attr attr){
        attrService.updateById(attr);
        return AjaxResult.ok("修改成功");
    }

    @ApiOperation("根据ID删除属性")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<String> deleteByID(@ApiParam("属性ID") @PathVariable Long id){
        attrService.removeById(id);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public AjaxResult<String> batchRemove(@ApiParam(value = "属性ID列表",required = true) @RequestBody List<Long> ids){
        attrService.removeByIds(ids);
        return AjaxResult.ok("删除成功");
    }
}

