package io.xccit.store.activity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xccit.store.activity.mapper.ActivityInfoMapper;
import io.xccit.store.activity.service.IActivityInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.model.activity.ActivityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Service
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfo> implements IActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;
    @Override
    public IPage<ActivityInfo> getPageList(Page<ActivityInfo> activityInfoPage) {
        IPage<ActivityInfo> page = activityInfoMapper.selectPage(activityInfoPage, null);
        page.getRecords().stream().forEach(item -> {
            item.setActivityTypeString(item.getActivityType().getComment());
        });
        return page;
    }
}
