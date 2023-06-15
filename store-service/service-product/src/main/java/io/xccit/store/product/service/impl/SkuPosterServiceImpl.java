package io.xccit.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.xccit.store.model.product.SkuPoster;
import io.xccit.store.product.mapper.SkuPosterMapper;
import io.xccit.store.product.service.ISkuPosterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品海报表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster> implements ISkuPosterService {

    @Autowired
    private SkuPosterMapper skuPosterMapper;

    @Override
    public List<SkuPoster> getListBySkuID(Long id) {
        LambdaQueryWrapper<SkuPoster> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuPoster::getSkuId,id);
        return skuPosterMapper.selectList(wrapper);
    }
}
