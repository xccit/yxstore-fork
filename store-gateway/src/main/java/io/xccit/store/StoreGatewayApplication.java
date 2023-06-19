package io.xccit.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author CH_ywx
 * @date 2023-06-19
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StoreGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreGatewayApplication.class,args);
        System.out.println("网关模块启动成功...");
    }
}
