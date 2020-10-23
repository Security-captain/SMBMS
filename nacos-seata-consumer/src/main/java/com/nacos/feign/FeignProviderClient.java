package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("nacos-seata-provider")
public interface FeignProviderClient {

}
