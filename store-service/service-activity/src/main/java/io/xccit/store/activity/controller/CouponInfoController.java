package io.xccit.store.activity.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.activity.service.ICouponInfoService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.activity.CouponInfo;
import io.xccit.store.vo.activity.CouponRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Api(tags = "优惠券接口")
@RestController
@RequestMapping("/admin/activity/couponInfo")
//@CrossOrigin
public class CouponInfoController {

    @Autowired
    private ICouponInfoService couponInfoService;

    @ApiOperation("分页查询")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<CouponInfo>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                     @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize){
        Page<CouponInfo> couponInfoPage = new Page<>(pageNo, pageSize);
        IPage<CouponInfo> pageModel = couponInfoService.getPageList(couponInfoPage);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("根据ID获取")
    @GetMapping("/get/{couponID}")
    public AjaxResult<CouponInfo> getByID(@ApiParam(value = "优惠券ID",required = true) @PathVariable Long couponID){
        CouponInfo couponInfo = couponInfoService.getCouponInfoByID(couponID);
        return AjaxResult.ok(couponInfo);
    }

    @ApiOperation("添加优惠券")
    @PostMapping("/save")
    public AjaxResult<String> saveCoupon(@RequestBody CouponInfo couponInfo){
        couponInfoService.save(couponInfo);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("根据优惠券ID获取优惠券规则数据")
    @GetMapping("/findCouponRuleList/{couponID}")
    public AjaxResult<Map<String,Object>> getCouponRegByID(@ApiParam("优惠券ID") @PathVariable Long couponID){
        Map<String,Object> result = couponInfoService.getCouponRegByID(couponID);
        return AjaxResult.ok(result);
    }

    @ApiOperation("添加优惠券规则")
    @PostMapping("/saveCouponRule")
    public AjaxResult<String> saveCouponReg(@RequestBody CouponRuleVo couponRuleVo){
        couponInfoService.saveCouponReg(couponRuleVo);
        return AjaxResult.ok("添加成功");
    }
}

