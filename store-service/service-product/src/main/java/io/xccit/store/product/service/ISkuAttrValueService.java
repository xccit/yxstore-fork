package io.xccit.store.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.SkuAttrValue;

import java.util.List;

/**
 * <p>
 * spu属性值 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface ISkuAttrValueService extends IService<SkuAttrValue> {

    List<SkuAttrValue> getListByID(Long id);

    List<SkuAttrValue> getListBySkuID(Long id);
}
