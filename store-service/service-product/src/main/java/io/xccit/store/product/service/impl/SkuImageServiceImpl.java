package io.xccit.store.product.service.impl;

import io.xccit.store.product.entity.SkuImage;
import io.xccit.store.product.mapper.SkuImageMapper;
import io.xccit.store.product.service.ISkuImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class SkuImageServiceImpl extends ServiceImpl<SkuImageMapper, SkuImage> implements ISkuImageService {

}
