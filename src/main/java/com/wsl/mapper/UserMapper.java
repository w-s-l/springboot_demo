package com.wsl.mapper;

import com.wsl.domain.User;
import org.springframework.stereotype.Repository;

import javax.print.attribute.HashDocAttributeSet;
import java.util.*;

@Repository
public class UserMapper {
    private static Map<String, User> map = new HashMap<>();
    static {
        map.put("jack",new User(1,"jack","123"));
        map.put("老王",new User(2,"老王","12345"));
        map.put("tom",new User(3,"tom","123456"));
    }
    public User login(String username,String pwd){
        User user = map.get(username);
        if(user!=null&&user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }


    public List<User> userList(){
        List<User> list =new ArrayList<>();
        list.addAll(map.values());
        return list;
    }
}
