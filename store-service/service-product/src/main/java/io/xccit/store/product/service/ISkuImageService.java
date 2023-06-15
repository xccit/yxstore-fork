package io.xccit.store.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.SkuImage;

import java.util.List;

/**
 * <p>
 * 商品图片 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface ISkuImageService extends IService<SkuImage> {

    List<SkuImage> getListBySkuInfoID(Long id);
}
