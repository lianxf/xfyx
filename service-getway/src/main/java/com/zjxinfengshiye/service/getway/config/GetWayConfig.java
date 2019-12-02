package com.zjxinfengshiye.service.getway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetWayConfig {

    @Autowired
    ZuulProperties zuulProperties;

    @Autowired
    ServerProperties server;

    @Bean
    public CustomRouteLocator customRouteLocator(){
        CustomRouteLocator customRouteLocator = new CustomRouteLocator(this.server.getServlet().getContextPath(),zuulProperties);
        return customRouteLocator;
    }
}
