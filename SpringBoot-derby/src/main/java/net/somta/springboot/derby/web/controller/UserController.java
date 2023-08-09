package net.somta.springboot.derby.web.controller;

import java.util.ArrayList;
import java.util.List;

import net.somta.springboot.derby.mapper.UserMapper;
import net.somta.springboot.derby.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	//@GetMapping("/queryUserById")
	@RequestMapping(value = "/queryUserById",method=RequestMethod.GET)
	public User queryUserById() {
		User user = new User();
		/*user.setId("123456");
		user.setName("张三");
		user.setAge(12);*/
        return user;
    }
	
	@GetMapping("/queryUserList")
	public List<User> queryUserList() {
		List<User> list = null;
		list = userMapper.queryUserList();
        return list;
    }
	
}
