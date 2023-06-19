package io.xccit.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.model.product.Category;
import io.xccit.store.product.mapper.CategoryMapper;
import io.xccit.store.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.vo.product.CategoryQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public IPage<Category> getPageList(Page<Category> categoryPage, CategoryQueryVo categoryQueryVo) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        String name = categoryQueryVo.getName();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like(Category::getName,name);
        }
        return categoryMapper.selectPage(categoryPage,queryWrapper);
    }

    @Override
    public List<Category> findCateGoryByRangeIDs(List<Long> categoryIds) {
        return categoryMapper.selectBatchIds(categoryIds);
    }
}
