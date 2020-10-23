package com.nacos.controller;

import com.nacos.feign.FeignUserClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

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

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/frame")
    public String frame(){
        return "frame";
    }
    @GetMapping("/bill")
    public String bill(){
        return "bill";
    }
    @GetMapping("/billadd")
    public String billadd(){
        return "billadd";
    }
    @GetMapping("/provider")
    public String provider(){
        return "provider";
    }
    @GetMapping("/provideradd")
    public String provideradd(){
        return "provideradd";
    }
    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("userlist",feignUserClient.user());
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
