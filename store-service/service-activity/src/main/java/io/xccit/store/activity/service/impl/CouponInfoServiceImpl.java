package io.xccit.store.activity.service.impl;

import io.xccit.store.activity.mapper.CouponInfoMapper;
import io.xccit.store.activity.service.ICouponInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.model.activity.CouponInfo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements ICouponInfoService {

}
