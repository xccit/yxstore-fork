package io.xccit.store.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.product.Category;
import io.xccit.store.product.service.ICategoryService;
import io.xccit.store.vo.product.CategoryQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Api(tags = "商品分类接口")
@RestController
@RequestMapping("/admin/product/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("商品分类分页条件查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<Category>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                   @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize,
                                                   @ApiParam("查询条件请求体")CategoryQueryVo categoryQueryVo){
        Page<Category> categoryPage = new Page<>(pageNo,pageSize);
        IPage<Category> pageModel = categoryService.getPageList(categoryPage,categoryQueryVo);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("根据ID获取分类信息")
    @GetMapping("/get/{id}")
    public AjaxResult<Category> getCategoryByID(@PathVariable Long id){
        return AjaxResult.ok(categoryService.getById(id));
    }

    @ApiOperation("添加商品分类")
    @PostMapping("/save")
    public AjaxResult<String> saveCategory(@RequestBody Category category){
        categoryService.save(category);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("更新商品分类")
    @PutMapping("/update")
    public AjaxResult<String> updateCategory(@RequestBody Category category){
        categoryService.updateById(category);
        return AjaxResult.ok("更新成功");
    }

    @ApiOperation("根据ID删除商品分类")
    @DeleteMapping("/remove/{id}")
    public AjaxResult<String> deleteCategoryByID(@PathVariable Long id){
        categoryService.removeById(id);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("批量删除商品分类")
    @DeleteMapping("batchRemove")
    public AjaxResult<String> batchRemoveCategory(@RequestBody List<Long> ids){
        categoryService.removeByIds(ids);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("获取商品信息列表")
    @GetMapping("/findAllList")
    public AjaxResult<List<Category>> findAllList(){
        List<Category> list = categoryService.list();
        return AjaxResult.ok(list);
    }
}

