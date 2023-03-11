package net.somta.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.somta.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户控制类")
@RestController
public class UserController {

    @Operation(summary = "新增用户")
    @PostMapping("addUser")
    public String addUser(User user){
        System.out.println(user);
        return "success";
    }
}
