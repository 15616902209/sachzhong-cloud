package com.sachzhong.gateway.controller;

import com.sachzhong.core.dto.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 @Author: SachZhong
 @Description:
 @Date Created in 2021/5/31 11:40
 */
@RestController
@RefreshScope
public class GateWayController {

    @Value("${name}")
    private String name;
    @GetMapping("getName")
    public BaseResponseDTO getName(){
        return new BaseResponseDTO().Success(this.name);
    }
}