package io.xccit.store.activity.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.activity.CouponInfo;
import io.xccit.store.vo.activity.CouponRuleVo;

import java.util.Map;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
public interface ICouponInfoService extends IService<CouponInfo> {

    IPage<CouponInfo> getPageList(Page<CouponInfo> couponInfoPage);

    CouponInfo getCouponInfoByID(Long couponID);

    Map<String, Object> getCouponRegByID(Long couponID);

    void saveCouponReg(CouponRuleVo couponRuleVo);
}
