package net.somta.springboot.derby.mapper;

import net.somta.springboot.derby.model.User;

import java.util.List;


public interface UserMapper {

	int addUser(User user);
	
	int deleteUserById(Long id);
	
	int updateUserById(User user);

	User queryUserById(Long id);
	
	List<User> queryUserList();
}
