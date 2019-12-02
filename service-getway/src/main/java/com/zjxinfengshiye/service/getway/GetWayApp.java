package com.zjxinfengshiye.service.getway;

import commons.boot.annotation.EnableCommonsBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableCommonsBoot
@EnableEurekaClient
@SpringBootApplication
public class GetWayApp {
    public static void main(String[] args) {
        SpringApplication.run(GetWayApp.class,args);
    }
}
