package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nacos-seata-user")
public interface FeignUserClient {

    @PostMapping("/login")
    int login(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword);

    @GetMapping("/user")
    String user();
}
