package com.nacos.controller;

import com.nacos.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProviderController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/provider")
    public String provider(){
        return "provider";
    }

    @GetMapping("/provideradd")
    public String provideradd(){
        return "provideradd";
    }
}
