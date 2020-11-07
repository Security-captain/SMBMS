package com.nacos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nacos.mapper.UserMapper;
import com.nacos.pojo.User;
import com.nacos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
