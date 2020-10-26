package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-seata-provider")
public interface FeignProviderClient {
    @GetMapping("/provider")
    String provider();
}
