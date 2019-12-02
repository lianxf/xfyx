package com.zjxinfengshiye.service.getway.config;

import commons.boot.swagger.EnableSwagger;
import commons.boot.swagger.Header;
import commons.boot.upload.ChangeUploadFileMaxSize;
import commons.core.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CommonsConfig {

    @Value("${server.port}")
    private Integer port;

    @Bean
    public ChangeUploadFileMaxSize changeUploadFileMaxSize(){
        ChangeUploadFileMaxSize changeUploadFileMaxSize = new ChangeUploadFileMaxSize();
        return changeUploadFileMaxSize;
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
        return enableSwagger;
    }
}