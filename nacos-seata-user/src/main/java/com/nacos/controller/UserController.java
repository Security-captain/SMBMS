package com.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nacos.pojo.User;
import com.nacos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(String userCode,String userPassword){
        return userService.count(new QueryWrapper<User>().eq("userCode",userCode).eq("userPassword",userPassword));
    }

    @GetMapping("/user")
    public Map<String,Object> user(@RequestParam Map<String,Object> mp){
        if("query".equals(mp.get("method"))){//查询
            if(mp.get("pageIndex")!=null){//pageIndex不为空
                Page<User> page =new Page<>(Integer.parseInt(mp.get("pageIndex").toString()),5);
                if(mp.get("queryname")!="" && Integer.parseInt(mp.get("queryUserRole").toString())>0){//条件分页查询 queryname queryUserRole都不为空
                    IPage<User> iPage= userService.page(
                            page,new QueryWrapper<User>()
                                    .like("userName",mp.get("queryname").toString())
                                    .eq("userRole",Integer.parseInt(mp.get("queryUserRole").toString())));
                    mp.put("Total",iPage.getTotal());
                    mp.put("Current",iPage.getCurrent());
                    mp.put("Pages",iPage.getPages());
                    mp.put("Records",iPage.getRecords());
                    return mp;
                }else if(mp.get("queryname")!="" && Integer.parseInt(mp.get("queryUserRole").toString())<=0){//条件分页查询 queryUserRole为空
                    IPage<User> iPage= userService.page(
                            page,new QueryWrapper<User>()
                                    .like("userName",mp.get("queryname").toString()));
                    mp.put("Total",iPage.getTotal());
                    mp.put("Current",iPage.getCurrent());
                    mp.put("Pages",iPage.getPages());
                    mp.put("Records",iPage.getRecords());
                    return mp;
                }else if(mp.get("queryname")=="" && Integer.parseInt(mp.get("queryUserRole").toString())>0){//条件分页查询 queryname为空
                    IPage<User> iPage= userService.page(
                            page,new QueryWrapper<User>()
                                    .eq("userRole",Integer.parseInt(mp.get("queryUserRole").toString())));
                    mp.put("Total",iPage.getTotal());
                    mp.put("Current",iPage.getCurrent());
                    mp.put("Pages",iPage.getPages());
                    mp.put("Records",iPage.getRecords());
                    return mp;
                }else{//无条件分页查询  queryname queryUserRoled都为空
                    IPage<User> iPage= userService.page(page,null);
                    mp.put("Total",iPage.getTotal());
                    mp.put("Current",iPage.getCurrent());
                    mp.put("Pages",iPage.getPages());
                    mp.put("Records",iPage.getRecords());
                    return mp;
                }
            }else{//默认分页查询
                Page<User> page =new Page<>(1,5);
                IPage<User> iPage= userService.page(page,null);
                mp.put("queryname","");
                mp.put("queryUserRole",0);

                mp.put("Total",iPage.getTotal());
                mp.put("Current",iPage.getCurrent());
                mp.put("Pages",iPage.getPages());
                mp.put("Records",iPage.getRecords());
                return mp;
            }
        }else if("view".equals(mp.get("method"))){//查详情
            User user=userService.getOne(new QueryWrapper<User>().eq("id",mp.get("uid")));
            mp.put("user",user);
            return mp;
        }else if("modify".equals(mp.get("method"))){//查详情
            User user=userService.getOne(new QueryWrapper<User>().eq("id",mp.get("uid")));
            mp.put("user",user);
            return mp;
        }
        return mp;
    }

    @PostMapping("/user")
    public boolean user(String method,User user){
        if("modifyexe".equals(method)) {
            return userService.update(new UpdateWrapper<User>()
                    .set("userName", user.getUserName()).set("gender", user.getGender()).set("birthday", user.getBirthday()).set("phone", user.getPhone()).set("address", user.getAddress()).set("userRole", user.getUserRole())
                    .eq("id", user.getId()));
        }else{
            return false;
        }
    }
}
