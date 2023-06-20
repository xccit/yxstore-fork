package io.xccit.store.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xccit.store.model.user.User;
import io.xccit.store.vo.user.LeaderAddressVo;
import io.xccit.store.vo.user.UserLoginVo;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description
 */
public interface IUserService extends IService<User> {
    User getUserInfoByOpenID(String openID);

    LeaderAddressVo getLeaderAddressByUserID(Long id);

    UserLoginVo getUserLoginVoByID(Long id);
}
