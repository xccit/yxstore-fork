# 整合Gateway优雅解决跨域

## 创建模块及启动类

> 本项目中，网关模块直接在父工程下

```java
@SpringBootApplication
@EnableDiscoveryClient
public class StoreGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreGatewayApplication.class,args);
        System.out.println("网关模块启动成功...");
    }
}
```

## 导入依赖

```xml
<dependencies>
    <!--依赖nacos组件，服务注册到网关中才能用-->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
    <!-- gateway组件 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
</dependencies>
```



## 添加网关配置

```yaml
spring:
  cloud:
    # 网关
    gateway:
      discovery:
        locator:
          enabled: true
      routes:
        - id: service-acl
          uri: lb://service-acl
          predicates:
            - Path=/*/acl/**

        - id: service-sys
          uri: lb://service-sys
          predicates:
            - Path=/*/sys/**

        - id: service-product
          uri: lb://service-product
          predicates:
            - Path=/*/product/**

        - id: service-activity
          uri: lb://service-activity
          predicates:
            - Path=/*/activity/**

        - id: service-search
          uri: lb://service-search
          predicates:
            - Path=/*/search/**
```

## 跨域配置类

```java
/**
 * @author CH_ywx
 * @date 2023-06-19
 * @description 跨域配置
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
```

> 注意:测试阶段解决跨域问题,使用@CrossOrigin注解配合Nginx反向代理临时解决跨域,添加此配置类整合Gateway后为防止引起不必要的程序报错就可以不用再添加@CrossOrigin注解了.

## 前端baseUrl修改

> 网关模块的port为9090,此时前端如果跟nginx反向代理配置的port一样,且nginx配置为9090,那么就可以不用再修改,如果不一样,前端必须修改为gateway模块配置的port,此时关闭Nginx，重启后端项目，前端再次访问，可以使用maven的clean对整个项目执行，然后install，最后再重启后端项目

![image-20230619214708713](%E6%95%B4%E5%90%88Gateway.assets/image-20230619214708713.png)

![image-20230619214730632](%E6%95%B4%E5%90%88Gateway.assets/image-20230619214730632.png)

## 测试报错503

![image-20230619215916472](%E6%95%B4%E5%90%88Gateway.assets/image-20230619215916472.png)

> 测试报错503时,检查nacos中有无网关服务,如果没有,检查网关模块的pom依赖以及启动类是否加服务注册注解