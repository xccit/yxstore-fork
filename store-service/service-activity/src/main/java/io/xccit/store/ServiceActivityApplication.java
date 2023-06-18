package io.xccit.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceActivityApplication.class,args);
    }
}
