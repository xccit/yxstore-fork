package io.xccit.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CH_ywx
 * @date 2023-06-16
 * @description
 */
//取消自动装配数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient //nacos服务注册
@EnableFeignClients //feign调用
public class ServiceSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSearchApplication.class,args);
        System.out.println("商品搜索模块启动成功");
    }
}
