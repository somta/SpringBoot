package com.somta.springboot.service;

import com.somta.springboot.pojo.User;

/**
 * Created by Kevin on 2019/1/22.
 */
public interface IUserService {
    
    User queryUserById(long id);
}
