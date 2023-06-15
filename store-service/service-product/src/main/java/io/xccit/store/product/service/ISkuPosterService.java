package io.xccit.store.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.product.SkuPoster;

import java.util.List;

/**
 * <p>
 * 商品海报表 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
public interface ISkuPosterService extends IService<SkuPoster> {

    List<SkuPoster> getListBySkuID(Long id);
}
