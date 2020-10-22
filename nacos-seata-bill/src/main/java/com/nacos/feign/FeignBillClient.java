package com.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "nacos-seata-consumer")
public class FeignBillClient {

}
