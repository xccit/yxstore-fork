package io.xccit.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description 系统管理模块启动类
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSysApplication.class,args);
        System.out.println("系统管理模块启动成功...");
    }
}
