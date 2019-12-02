package com.zjxinfengshiye.service.admin.config;

import commons.boot.security.EnableShiroSecurity;
import commons.boot.security.ShiroSecurityConfig;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomShiroSecurityConfig extends ShiroSecurityConfig {


    @Override
    public EnableShiroSecurity enableShiroSecurity() {
        EnableShiroSecurity enableShiroSecurity = new EnableShiroSecurity();

        enableShiroSecurity.setRedisHost("39.104.99.211");
        enableShiroSecurity.setRedisPassword("li203204");

        enableShiroSecurity.setTokenLiveHours(6);
        enableShiroSecurity.setTokenSalt("盐");

        List<String> anonUrls = new ArrayList<>();
        anonUrls.add("/swagger*");
        anonUrls.add("/favicon.icon");
        anonUrls.add("/webjars/**");
        anonUrls.add("/v2/**");
        anonUrls.add("/swagger-resources/**");
        anonUrls.add("/constant/**");
        enableShiroSecurity.setAnonUrls(anonUrls);

        List<String> authUrls = new ArrayList<>();
        authUrls.add("/**");
        enableShiroSecurity.setAuthUrls(authUrls);
        return enableShiroSecurity;
    }
}