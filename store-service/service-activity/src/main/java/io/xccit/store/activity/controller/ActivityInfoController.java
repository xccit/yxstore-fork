package io.xccit.store.activity.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xccit.store.activity.service.IActivityInfoService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.activity.ActivityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Api(tags = "活动接口")
@RestController
@RequestMapping("/admin/activity/activityInfo")
@CrossOrigin
public class ActivityInfoController {

    @Autowired
    private IActivityInfoService activityInfoService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<ActivityInfo>> getPageList(@PathVariable Long pageNo, @PathVariable Long pageSize){
        Page<ActivityInfo> activityInfoPage = new Page<>(pageNo, pageSize);
        IPage<ActivityInfo> pageModel = activityInfoService.getPageList(activityInfoPage);
        return AjaxResult.ok(pageModel);
    }

}
