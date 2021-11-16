package com.somta.springboot.service.internal;

import com.somta.springboot.dao.UserDao;
import com.somta.springboot.pojo.User;
import com.somta.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin on 2019/1/22.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserById(long id) {
        return userDao.queryUserById(id);
    }
}
