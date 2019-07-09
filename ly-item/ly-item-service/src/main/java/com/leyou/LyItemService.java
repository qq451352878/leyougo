package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableTransactionManagement
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class,args);
    }
}
