package com.nacos.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nacos.pojo.User;
import com.nacos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("userCode") String userCode,@RequestParam("userPassword") String userPassword, Model model){
        int count=userService.count(new QueryWrapper<User>().eq("userCode",userCode).eq("userPassword",userPassword));
        if(count==1){
            model.addAttribute("userCode",userCode);
            return "frame";
        }else{
            model.addAttribute("error","用户名或密码不正确");
            return "login";
        }
    }

}
