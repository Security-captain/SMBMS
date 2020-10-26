package com.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.nacos.feign.FeignProviderClient;
import com.nacos.pojo.Bill;
import com.nacos.pojo.Provider;
import com.nacos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProviderController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/provider")
    public String provider(Model model){
        List<Provider> providerlist= JSONObject.parseArray(feignProviderClient.provider(), Provider.class);
        model.addAttribute("providerlist",providerlist);
        return "provider";
    }

    @GetMapping("/provideradd")
    public String provideradd(){
        return "provideradd";
    }
}
