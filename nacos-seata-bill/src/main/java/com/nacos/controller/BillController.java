package com.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.nacos.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/bill")
    public String bill(){
        return JSON.toJSONString(billService.list());
    }

}
