package io.xccit.store.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.Category;
import io.xccit.store.vo.product.CategoryQueryVo;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface ICategoryService extends IService<Category> {

    IPage<Category> getPageList(Page<Category> categoryPage, CategoryQueryVo categoryQueryVo);
}
