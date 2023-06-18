package io.xccit.store.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.activity.ActivityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Repository
public interface ActivityInfoMapper extends BaseMapper<ActivityInfo> {

    List<Long> selectExistsSkuID(List<Long> skuIDList);
}
