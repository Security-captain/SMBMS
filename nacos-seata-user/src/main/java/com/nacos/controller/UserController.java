package com.nacos.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nacos.pojo.User;
import com.nacos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(String userCode,String userPassword){
        return userService.count(new QueryWrapper<User>().eq("userCode",userCode).eq("userPassword",userPassword));
    }

    @GetMapping("/user")
    public List<User> user(){
        return userService.list();
    }
}
