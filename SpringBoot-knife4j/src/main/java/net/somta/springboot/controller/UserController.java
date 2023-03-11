package net.somta.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.somta.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户控制类")
@RestController
public class UserController {

    @ApiOperation(value = "新增用户")
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        return "success";
    }


    /**
     * todo 这种结构不在界面model中展示
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户")
    @PostMapping("updateUser")
    public String updateUser(User user){
        System.out.println(user);
        return "success";
    }
}
