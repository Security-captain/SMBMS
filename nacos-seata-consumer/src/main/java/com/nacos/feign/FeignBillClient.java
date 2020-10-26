package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-seata-bill")
public interface FeignBillClient {
    @GetMapping("/bill")
    String bill();
}
