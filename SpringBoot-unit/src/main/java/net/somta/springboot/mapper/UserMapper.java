package net.somta.springboot.mapper;

import net.somta.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

	int addUser(User user);
	
	int deleteUserById(Long id);
	
	int updateUserById(User user);

	User queryUserById(Long id);
	
	List<User> queryUserList();
}
