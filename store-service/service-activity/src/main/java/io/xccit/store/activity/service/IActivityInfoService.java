package io.xccit.store.activity.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.activity.ActivityInfo;
import io.xccit.store.model.activity.ActivityRule;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.vo.activity.ActivityRuleVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
public interface IActivityInfoService extends IService<ActivityInfo> {

    IPage<ActivityInfo> getPageList(Page<ActivityInfo> activityInfoPage);

    Map<String, Object> findActivityRuleList(Long activityID);

    void saveActivityRuleAndSku(ActivityRuleVo activityRuleVo);

    List<SkuInfo> getSkuInfoByKeyword(String keyword);
}
