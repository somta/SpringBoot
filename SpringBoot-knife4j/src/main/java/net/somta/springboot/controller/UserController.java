package net.somta.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.somta.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户控制类")
@RestController
public class UserController {

    @ApiOperation(value = "邮箱")
    @PostMapping("addUser")
    public String addUser(User user){
        System.out.println(user);
        return "success";
    }
}
