package io.xccit.store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xccit.store.model.user.UserDelivery;
import org.springframework.stereotype.Repository;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description 提货记录Mapper
 */
@Repository
public interface IUserDeliveryMapper extends BaseMapper<UserDelivery> {
}
