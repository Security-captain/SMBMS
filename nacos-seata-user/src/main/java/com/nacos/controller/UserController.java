package com.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.pojo.User;
import com.nacos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(@RequestParam("userCode") String userCode,@RequestParam("userPassword") String userPassword){
        return userService.count(new QueryWrapper<User>().eq("userCode",userCode).eq("userPassword",userPassword));
    }

    @GetMapping("/user")
    public String user(@RequestParam Map<String,Object> mp){
        if("query".equals(mp.get("method"))){
            Page<User> page =new Page<>(1,5,false);
            IPage<User> iPage= userService.page(page,null);
            mp.put("Total",iPage.getTotal());
            mp.put("Current",iPage.getCurrent());
            mp.put("Pages",iPage.getPages());
            mp.put("Records",iPage.getRecords());
            return JSON.toJSONString(mp);
        }
        return "";
    }
}
