package io.xccit.store.product.service.impl;

import io.xccit.store.product.entity.Attr;
import io.xccit.store.product.mapper.AttrMapper;
import io.xccit.store.product.service.IAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

}
