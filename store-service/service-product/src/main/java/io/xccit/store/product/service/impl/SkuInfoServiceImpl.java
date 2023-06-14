package io.xccit.store.product.service.impl;

import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.product.mapper.SkuInfoMapper;
import io.xccit.store.product.service.ISkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements ISkuInfoService {

}
