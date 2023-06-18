package io.xccit.store.activity.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.activity.ActivitySku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 活动参与商品 Mapper 接口
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-17
 */
@Repository
public interface ActivitySkuMapper extends BaseMapper<ActivitySku> {

}
