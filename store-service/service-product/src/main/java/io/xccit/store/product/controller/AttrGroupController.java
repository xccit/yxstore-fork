package io.xccit.store.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.product.AttrGroup;
import io.xccit.store.product.service.IAttrGroupService;
import io.xccit.store.vo.product.AttrGroupQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Api(tags = "属性分组接口")
@RestController
@RequestMapping("/admin/product/attrGroup")
@CrossOrigin
public class AttrGroupController {

    @Autowired
    private IAttrGroupService attrGroupService;

    @ApiOperation("分页条件查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<AttrGroup>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                    @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
                                                    @ApiParam("属性分组条件请求体") AttrGroupQueryVo attrGroupQueryVo){
        Page<AttrGroup> attrGroupPage = new Page<>(pageNo, pageSize);
        IPage<AttrGroup> pageModel = attrGroupService.getPageList(attrGroupPage,attrGroupQueryVo);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/get/{id}")
    public AjaxResult<AttrGroup> getAttrGroupByID(@ApiParam("属性分组ID") @PathVariable Long id){
        return AjaxResult.ok(attrGroupService.getById(id));
    }

    @ApiOperation("添加")
    @PostMapping("/save")
    public AjaxResult<String> saveAttrGroup(@ApiParam("属性分组请求体") @RequestBody AttrGroup attrGroup){
        attrGroupService.save(attrGroup);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("修改")
    @PutMapping("/update")
    public AjaxResult<String> updateAttrGroup(@ApiParam("属性分组请求体") @RequestBody AttrGroup attrGroup){
        attrGroupService.updateById(attrGroup);
        return AjaxResult.ok("更新成功");
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<String> deleteByID(@ApiParam("ID") @PathVariable Long id){
        attrGroupService.removeById(id);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public AjaxResult<String> batchRemove(@RequestBody List<Long> ids){
        attrGroupService.removeByIds(ids);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("获取属性分组列表")
    @GetMapping("/findAllList")
    public AjaxResult<List<AttrGroup>> findAllList(){
        return AjaxResult.ok(attrGroupService.list());
    }
}

