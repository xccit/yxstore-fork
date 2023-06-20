package io.xccit.store.user.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description 小程序信息封装
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${wx.open.app_id}")
    private String appID;
    @Value("${wx.open.app_secret}")
    private String appSecret;

    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;

    /**
     * 对象初始化后将值注入到bean属性
     * @throws Exception 异常信息
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appID;
        WX_OPEN_APP_SECRET = appSecret;
    }
}
