package net.somta.springboot.web.controller;

import net.somta.springboot.mapper.UserMapper;
import net.somta.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@GetMapping(value = "/addUser")
	public Boolean addUser() {
		User user = new User();
		user.setId(123L);
		user.setName("张三");
		user.setAge(12);
		userMapper.addUser(user);
		return true;
	}

	@GetMapping(value = "/queryUserById")
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
