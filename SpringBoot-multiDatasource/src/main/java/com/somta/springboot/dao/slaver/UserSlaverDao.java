package com.somta.springboot.dao.slaver;

import java.util.List;

import com.somta.springboot.pojo.User;

public interface UserSlaverDao {

	int addUser(User user);
	
	int deleteUserById(Long id);
	
	int updateUserById(User user);

	User queryUserById(Long id);
	
	List<User> queryUserList();
}
