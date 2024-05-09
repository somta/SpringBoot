package net.somta.springboot.service.impl;

import net.somta.springboot.mapper.UserMapper;
import net.somta.springboot.pojo.User;
import net.somta.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("user 不能为空");
        }
        userMapper.addUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        if(userId == null){
            throw new IllegalArgumentException("userId不能为空");
        }
        return userMapper.queryUserById(userId);
    }
}
