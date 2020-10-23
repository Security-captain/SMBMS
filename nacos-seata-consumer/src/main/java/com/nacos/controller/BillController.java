package com.nacos.controller;

import com.nacos.feign.FeignBillClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillController {

    @Autowired
    private FeignBillClient feignBillClient;

    @GetMapping("/bill")
    public String bill(){
        return "bill";
    }

    @GetMapping("/billadd")
    public String billadd(){
        return "billadd";
    }
}
