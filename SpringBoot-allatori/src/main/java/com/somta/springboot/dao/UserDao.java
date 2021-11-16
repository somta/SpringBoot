package com.somta.springboot.dao;

import java.util.List;

import com.somta.springboot.pojo.User;

public interface UserDao {

	int addUser(User user);
	
	int deleteUserById(Long id);
	
	int updateUserById(User user);

	User queryUserById(Long id);
	
	List<User> queryUserList();
}
