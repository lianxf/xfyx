package com.zjxinfengshiye.service.wchat;

import commons.boot.annotation.EnableCommonsBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableCommonsBoot
@EnableEurekaClient
@SpringBootApplication
public class WChatApp {
    public static void main(String[] args) {
        SpringApplication.run(WChatApp.class,args);
    }
}
