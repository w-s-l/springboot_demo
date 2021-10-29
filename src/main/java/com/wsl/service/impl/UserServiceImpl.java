package com.wsl.service.impl;

import com.wsl.domain.User;
import com.wsl.mapper.UserMapper;
import com.wsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public static Map<String,User> sessionMap = new HashMap<>();

    @Override
    public String login(String username, String pwd) {
        User login = userMapper.login(username, pwd);
        if(login==null){
            return null;
        }else{
            String token = UUID.randomUUID().toString();
            sessionMap.put(token,login);
            return token;
        }
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }
}
