package com.zjxinfengshiye.service.admin.config;

import commons.boot.cors.DisableCors;
import commons.boot.exception.EnableExceptionHandler;
import commons.boot.objectmapper.EnableObjectMapper;
import commons.boot.swagger.EnableSwagger;
import commons.boot.swagger.Header;
import commons.boot.upload.ChangeUploadFileMaxSize;
import commons.core.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@EnableSwagger2
@Configuration
public class CommonsConfig {

    @Value("${server.port}")
    private Integer port;

    @Bean
    public EnableExceptionHandler enableExceptionHandler(){
        EnableExceptionHandler enableExceptionHandler = new EnableExceptionHandler();
        return enableExceptionHandler;
    }

    @Bean
    public EnableObjectMapper enableObjectMapper(){
        EnableObjectMapper enableObjectMapper = new EnableObjectMapper();
        enableObjectMapper.setIsSerialNull(false);
        return enableObjectMapper;
    }

    @Bean
    public ChangeUploadFileMaxSize changeUploadFileMaxSize(){
        ChangeUploadFileMaxSize changeUploadFileMaxSize = new ChangeUploadFileMaxSize();
        return changeUploadFileMaxSize;
    }

    @Bean
    public DisableCors disableCors(){
        DisableCors disableCors = new DisableCors();
        disableCors.setExposedHeader(Arrays.asList("authorization"));
        return disableCors;
    }

    @Bean
    public EnableSwagger enableSwagger(){
        EnableSwagger enableSwagger = new EnableSwagger();

        Header header = new Header();
        header.setHead("authorization");
        header.setHeadDesc("登录凭证");
        enableSwagger.setHeader(header);
        enableSwagger.setHost(HttpServletRequestUtil.getLocalIP());
        enableSwagger.setPort(port);

        enableSwagger.setTitle("鑫峰易行后台接口");
        enableSwagger.setDescription("后台所有接口文档");
        return enableSwagger;
    }
}