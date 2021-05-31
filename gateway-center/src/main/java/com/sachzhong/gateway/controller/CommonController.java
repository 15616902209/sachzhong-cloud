package com.sachzhong.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 @Author: SachZhong
 @Description:
 @Date Created in 2021/5/31 11:40
 */
@RestController
@RefreshScope
@Slf4j
@RequestMapping("common-center")
public class CommonController {

    @Value("${name}")
    private String name;
    @GetMapping("getName")
    public String getName(){
        return "公共中心"+name;
    }
}