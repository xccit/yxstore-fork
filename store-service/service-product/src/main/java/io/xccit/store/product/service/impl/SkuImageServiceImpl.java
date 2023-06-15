package io.xccit.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xccit.store.model.product.SkuImage;
import io.xccit.store.product.mapper.SkuImageMapper;
import io.xccit.store.product.service.ISkuImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private SkuImageMapper skuImageMapper;
    @Override
    public List<SkuImage> getListBySkuInfoID(Long id) {
        LambdaQueryWrapper<SkuImage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuImage::getSkuId,id);
        return skuImageMapper.selectList(wrapper);
    }
}
