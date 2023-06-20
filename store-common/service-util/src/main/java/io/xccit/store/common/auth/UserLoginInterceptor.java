package io.xccit.store.common.auth;

import io.xccit.store.common.constant.RedisConst;
import io.xccit.store.common.utils.JwtHelper;
import io.xccit.store.vo.user.UserLoginVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description 用户登录拦截器
 */
public class UserLoginInterceptor implements HandlerInterceptor {

    private RedisTemplate<String,Object> redisTemplate;

    public UserLoginInterceptor(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.getUserInfo(request);
        return true;
    }

    /**
     * 获取用户信息
     * @param request
     */
    private void getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)){
            Long userID = JwtHelper.getUserID(token);
            //从redis获取用户信息
            UserLoginVo userLoginVo = (UserLoginVo)redisTemplate.opsForValue().get(RedisConst.USER_LOGIN_KEY_PREFIX + userID);
            if (userLoginVo != null){
                AuthContextHolder.setUserID(userID);
                AuthContextHolder.setWareID(userLoginVo.getWareId());
                AuthContextHolder.setUserLoginVo(userLoginVo);
            }
        }
    }
}
