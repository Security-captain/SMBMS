package com.nacos.controller;

import com.nacos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/frame")
    public String frame(Model model){
        return "frame";
    }

    @GetMapping("/bill")
    public String bill(Model model){
        return "bill";
    }

    @GetMapping("/billadd")
    public String billadd(Model model){
        return "billadd";
    }

    @GetMapping("/provider")
    public String provider(Model model){
        return "provider";
    }

    @GetMapping("/provideradd")
    public String provideradd(Model model){
        return "provideradd";
    }

    @GetMapping("/user")
    public String user(Model model){
        return "user";
    }

    @GetMapping("/useradd")
    public String useradd(Model model){
        return "useradd";
    }

    @GetMapping("/pwdmodify")
    public String pwdmodify(Model model){
        return "pwdmodify";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        return "login";
    }

}
