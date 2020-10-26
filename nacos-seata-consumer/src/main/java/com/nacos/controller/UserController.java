package com.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.nacos.feign.FeignUserClient;
import com.nacos.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

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
    public String user(Model model){
        List<User> userlist= JSONObject.parseArray(feignUserClient.user(), User.class);
        model.addAttribute("userlist",userlist);
        return "user";
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
