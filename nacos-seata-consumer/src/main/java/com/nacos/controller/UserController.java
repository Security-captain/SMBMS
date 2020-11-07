package com.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.nacos.feign.FeignUserClient;
import com.nacos.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
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
            try {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(userCode, userPassword);
                subject.login(token);
                return "frame";
            } catch (UnknownAccountException e) {
                model.addAttribute("error", "用户不存在");
                return "login";
            } catch (IncorrectCredentialsException e) {
                //密码不正确
                model.addAttribute("error", "密码不正确");
                return "login";
            }
        }else {
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
    @RequiresRoles("admin")
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
