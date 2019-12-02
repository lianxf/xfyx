package com.zjxinfengshiye.register.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterOneApp {
    public static void main(String[] args) {
        SpringApplication.run(RegisterOneApp.class,args);
    }
}
