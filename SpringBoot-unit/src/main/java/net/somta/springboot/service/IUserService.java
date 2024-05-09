package net.somta.springboot.service;

import net.somta.springboot.pojo.User;

public interface IUserService {

    void addUser(User user);

    User getUserById(Long userId);
}
