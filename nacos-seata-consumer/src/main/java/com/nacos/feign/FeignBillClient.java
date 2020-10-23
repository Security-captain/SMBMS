package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("nacos-seata-bill")
public interface FeignBillClient {

}
