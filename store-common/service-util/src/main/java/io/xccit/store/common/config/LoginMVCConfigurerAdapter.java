package io.xccit.store.common.config;

import io.xccit.store.common.auth.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description webmvc配置类
 */
@Configuration
public class LoginMVCConfigurerAdapter extends WebMvcConfigurationSupport {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor(redisTemplate))
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/weixin/wxLogin/*");
        super.addInterceptors(registry);
    }
}
