package io.xccit.store.product.service.impl;

import io.xccit.store.product.entity.SkuStockHistory;
import io.xccit.store.product.mapper.SkuStockHistoryMapper;
import io.xccit.store.product.service.ISkuStockHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku的库存历史记录 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class SkuStockHistoryServiceImpl extends ServiceImpl<SkuStockHistoryMapper, SkuStockHistory> implements ISkuStockHistoryService {

}
