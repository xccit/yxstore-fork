package io.xccit.store.product.mapper;

import io.xccit.store.model.product.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */

@Repository
public interface CategoryMapper extends BaseMapper<Category> {

}
