package com.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.nacos.feign.FeignUserClient;
import com.nacos.pojo.User;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private FeignUserClient feignUserClient;

    @PostMapping("/login")
    public String login(@RequestParam("userCode") String userCode,@RequestParam("userPassword") String userPassword,Model model){
        int count=feignUserClient.login(userCode,userPassword);
        if (count==1){
            return "frame";
        }else {
            model.addAttribute("error","用户名或密码不正确");
            return "login";
        }
    }

    @GetMapping("/frame")
    public String frame(){
        return "frame";
    }

    @GetMapping("/user")
    public String user(@RequestParam Map<String,Object> mp, Model model){
        if("query".equals(mp.get("method"))){
            mp= JSONObject.parseObject(feignUserClient.user(mp), Map.class);
            model.addAttribute("queryname",mp.get("queryname"));
            model.addAttribute("queryUserRole",mp.get("queryUserRole"));

            model.addAttribute("Total",mp.get("Total"));
            model.addAttribute("Current",mp.get("Current"));
            model.addAttribute("Pages",mp.get("Pages"));
            model.addAttribute("Records",mp.get("Records"));
            return "user";
        }else if("view".equals(mp.get("method"))){
            mp= JSONObject.parseObject(feignUserClient.user(mp), Map.class);
            model.addAttribute("user",mp.get("user"));
            return "userview";
        }else if("modify".equals(mp.get("method"))){
            mp= JSONObject.parseObject(feignUserClient.user(mp), Map.class);
            model.addAttribute("user",mp.get("user"));
            return "usermodify";
        }
        return "user";
    }

    @PostMapping("/user")
    public String user(@RequestParam("method") String method,@SpringQueryMap User user){
        if("modifyexe".equals(method)){
            feignUserClient.user(method,user);
            return "redirect:/user?method=query";
        }else{
            return "frame";
        }
    }

    @GetMapping("/useradd")
    public String useradd(){
        return "useradd";
    }

    @GetMapping("/pwdmodify")
    public String pwdmodify(){
        return "pwdmodify";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
