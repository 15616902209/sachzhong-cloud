package com.sachzhong.nacos_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 @Author: SachZhong
 @Description:
 @Date Created in 2021/5/29 16:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ResourcesCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourcesCenterApplication.class, args);
    }

}
