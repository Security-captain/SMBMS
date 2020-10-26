package com.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.nacos.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/provider")
    public String provider(){
        return JSON.toJSONString(providerService.list());
    }
}
