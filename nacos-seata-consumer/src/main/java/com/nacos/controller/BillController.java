package com.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.nacos.feign.FeignBillClient;
import com.nacos.pojo.Bill;
import com.nacos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BillController {

    @Autowired
    private FeignBillClient feignBillClient;

    @GetMapping("/bill")
    public String bill(Model model){
        List<Bill> billlist= JSONObject.parseArray(feignBillClient.bill(), Bill.class);
        model.addAttribute("billlist",billlist);
        return "bill";
    }

    @GetMapping("/billadd")
    public String billadd(){
        return "billadd";
    }
}
