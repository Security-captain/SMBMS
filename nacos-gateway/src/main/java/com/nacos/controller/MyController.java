package com.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MyController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String getTest(){
        System.out.println("test:"+port);
        return port;
    }
}
