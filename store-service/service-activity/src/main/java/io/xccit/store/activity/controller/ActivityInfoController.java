package io.xccit.store.activity.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.activity.service.IActivityInfoService;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.model.activity.ActivityInfo;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.vo.activity.ActivityRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
//@CrossOrigin
public class ActivityInfoController {

    @Autowired
    private IActivityInfoService activityInfoService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{pageNo}/{pageSize}")
    public AjaxResult<IPage<ActivityInfo>> getPageList(@ApiParam(value = "当前页",required = true) @PathVariable Long pageNo,
                                                       @ApiParam(value = "每页条数",required = true) @PathVariable Long pageSize){
        Page<ActivityInfo> activityInfoPage = new Page<>(pageNo, pageSize);
        IPage<ActivityInfo> pageModel = activityInfoService.getPageList(activityInfoPage);
        return AjaxResult.ok(pageModel);
    }

    @ApiOperation("添加活动")
    @PostMapping("/save")
    public AjaxResult<String> saveActivityInfo(@ApiParam(value = "活动信息",required = true) @RequestBody ActivityInfo activityInfo){
        activityInfoService.save(activityInfo);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("根据ID获取")
    @GetMapping("/get/{activityID}")
    public AjaxResult<ActivityInfo> getByID(@ApiParam(value = "活动ID",required = true) @PathVariable Long activityID){
        ActivityInfo activityInfo = activityInfoService.getById(activityID);
        activityInfo.setActivityTypeString(activityInfo.getActivityType().getComment());
        return AjaxResult.ok(activityInfo);
    }

    @ApiOperation("根据ID更新")
    @PutMapping("/update")
    public AjaxResult<String> updateByID(@ApiParam(value = "活动信息",required = true) @RequestBody ActivityInfo activityInfo){
        activityInfoService.updateById(activityInfo);
        return AjaxResult.ok("更新成功");
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/remove/{activityID}")
    public AjaxResult<String> deleteByID(@ApiParam(value = "活动ID",required = true) @PathVariable Long activityID){
        activityInfoService.removeById(activityID);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public AjaxResult<String> batchRemove(@ApiParam("ID列表") @RequestBody List<Long> ids){
        activityInfoService.removeByIds(ids);
        return AjaxResult.ok("删除成功");
    }

    @ApiOperation("获取活动规则+SKU列表")
    @GetMapping("/findActivityRuleList/{activityID}")
    public AjaxResult<Map<String,Object>> findActivityRuleList(@ApiParam("活动ID") @PathVariable Long activityID){
        Map<String,Object> activityRuleMap = activityInfoService.findActivityRuleList(activityID);
        return AjaxResult.ok(activityRuleMap);
    }

    @ApiOperation("添加活动规则及SKU")
    @PostMapping("/saveActivityRule")
    public AjaxResult<String> saveActivityRuleAndSku(@RequestBody ActivityRuleVo activityRuleVo){
        activityInfoService.saveActivityRuleAndSku(activityRuleVo);
        return AjaxResult.ok("添加成功");
    }

    @ApiOperation("根据关键字获取SKU,添加活动范围时搜索SKU选择")
    @GetMapping("findSkuInfoByKeyword/{keyword}")
    public AjaxResult<List<SkuInfo>> findSkuInfoByKeyword(@ApiParam("sku关键字") @PathVariable String keyword){
        List<SkuInfo> skuInfoList = activityInfoService.getSkuInfoByKeyword(keyword);
        return AjaxResult.ok(skuInfoList);
    }
}
