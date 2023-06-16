package io.xccit.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author CH_ywx
 * @date 2023-06-14
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class,args);
        System.out.println("商品管理模块启动成功");
    }
}
