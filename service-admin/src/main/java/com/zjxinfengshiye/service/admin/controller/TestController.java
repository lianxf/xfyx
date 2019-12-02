package com.zjxinfengshiye.service.admin.controller;

import commons.core.response.Response;
import commons.core.utils.RespUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "后台测试接口",tags = "后台测试接口")

@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation("测试")
    @GetMapping("")
    public Response test()throws Exception{
        return RespUtil.success("后台模块测试");
    }
}
