package io.xccit.store.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CH_ywx
 * @date 2023-06-10
 * @description 权限管理模块启动类
 */
@SpringBootApplication
public class ServiceAclApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class,args);
        System.out.println("权限管理模块启动成功...");
    }
}
