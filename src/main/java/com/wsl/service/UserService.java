package com.wsl.service;

import com.wsl.domain.User;

import java.util.List;

public interface UserService {
    String login(String username,String pwd);
    List<User> userList();
}
