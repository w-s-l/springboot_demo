package com.wsl.controller;

import com.wsl.domain.User;
import com.wsl.service.UserService;
import com.wsl.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        System.out.println(user.toString());
        String token = userService.login(user.getUsername(), user.getPwd());
        System.out.println(token);
        System.out.println(1);
        return token!=null?JsonData.buildSuccess(token):JsonData.buildError("账号密码错误！");
    }
    @GetMapping("list_user")
    public JsonData listUser(){
        List<User> users = userService.userList();
        return JsonData.buildSuccess(users);
    }
}
