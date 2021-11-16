package com.somta.springboot.web.controller;

import com.somta.springboot.pojo.User;
import com.somta.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kevin on 2019/1/22.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/queryUser")
    public User queryUser(){
        User user = userService.queryUserById(1L);
        System.out.println("id:"+user.getId()+"name:"+user.getName());
        return user;
    }

}
