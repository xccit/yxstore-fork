package io.xccit.store.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xccit.store.model.user.Leader;
import io.xccit.store.model.user.User;
import io.xccit.store.model.user.UserDelivery;
import io.xccit.store.user.mapper.ILeaderMapper;
import io.xccit.store.user.mapper.IUserDeliveryMapper;
import io.xccit.store.user.mapper.IUserMapper;
import io.xccit.store.user.service.IUserService;
import io.xccit.store.vo.user.LeaderAddressVo;
import io.xccit.store.vo.user.UserLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IUserDeliveryMapper userDeliveryMapper;
    @Autowired
    private ILeaderMapper leaderMapper;

    @Override
    public User getUserInfoByOpenID(String openID) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getOpenId, openID);
        return userMapper.selectOne(userLambdaQueryWrapper);
    }

    /**
     * 根据userID查询团长和提货点
     *
     * @param userId
     * @return
     */
    @Override
    public LeaderAddressVo getLeaderAddressByUserID(Long userId) {
        //从提货记录表中查出一条提货记录,条件是团长为该用户的默认团长
        LambdaQueryWrapper<UserDelivery> userDeliveryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userDeliveryLambdaQueryWrapper.eq(UserDelivery::getUserId, userId)
                .eq(UserDelivery::getIsDefault, 1);
        UserDelivery userDelivery = userDeliveryMapper.selectOne(userDeliveryLambdaQueryWrapper);
        if (userDelivery == null){
            return null;
        }
        //根据提货记录获取团长ID查询团长其他信息
        Leader leader = leaderMapper.selectById(userDelivery.getLeaderId());
        //封装数据
        LeaderAddressVo leaderAddressVo = new LeaderAddressVo();
        BeanUtils.copyProperties(leader, leaderAddressVo);
        leaderAddressVo.setUserId(userId);
        leaderAddressVo.setLeaderId(leader.getId());
        leaderAddressVo.setLeaderName(leader.getName());
        leaderAddressVo.setLeaderPhone(leader.getPhone());
        leaderAddressVo.setWareId(userDelivery.getWareId());
        leaderAddressVo.setStorePath(leader.getStorePath());
        return leaderAddressVo;
    }

    @Override
    public UserLoginVo getUserLoginVoByID(Long id) {
        //获取用户信息
        UserLoginVo userLoginVo = new UserLoginVo();
        User user = userMapper.selectById(id);
        userLoginVo.setUserId(user.getId());
        userLoginVo.setNickName(user.getNickName());
        userLoginVo.setPhotoUrl(user.getPhotoUrl());
        userLoginVo.setOpenId(user.getOpenId());
        userLoginVo.setIsNew(user.getIsNew());
        //如果是会员获取当前会员对应的仓库id
        LambdaQueryWrapper<UserDelivery> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserDelivery::getUserId, id);
        queryWrapper.eq(UserDelivery::getIsDefault, 1);
        UserDelivery userDelivery = userDeliveryMapper.selectOne(queryWrapper);
        if (null != userDelivery) {
            userLoginVo.setLeaderId(userDelivery.getLeaderId());
            userLoginVo.setWareId(userDelivery.getWareId());
        } else {
            userLoginVo.setLeaderId(1L);
            userLoginVo.setWareId(1L);
        }
        return userLoginVo;
    }
}
