package io.xccit.store.common.auth;

import io.xccit.store.vo.user.UserLoginVo;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description ThreadLocal工具类
 */
public class AuthContextHolder {
    private static ThreadLocal<Long> userID = new ThreadLocal<>();
    private static ThreadLocal<Long> wareID = new ThreadLocal<>();
    private static ThreadLocal<UserLoginVo> userLoginVo = new ThreadLocal<>();

    public static void setUserID(Long _userID){
        userID.set(_userID);
    }
    public static Long getUserID(){
        return userID.get();
    }
    public static void setWareID(Long _wareID){
        wareID.set(_wareID);
    }
    public static Long getWareID(){
        return wareID.get();
    }
    public static void setUserLoginVo(UserLoginVo _userLoginVo){
        userLoginVo.set(_userLoginVo);
    }
    public static UserLoginVo getUserLoginVo(){
        return userLoginVo.get();
    }

}
