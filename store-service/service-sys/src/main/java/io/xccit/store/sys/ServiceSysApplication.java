package io.xccit.store.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CH_ywx
 * @date 2023-06-13
 * @description 系统管理模块启动类
 */

@SpringBootApplication
public class ServiceSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSysApplication.class,args);
        System.out.println("系统管理模块启动成功...");
    }
}
