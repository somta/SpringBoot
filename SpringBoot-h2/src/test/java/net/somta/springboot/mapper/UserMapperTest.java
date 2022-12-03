package net.somta.springboot.mapper;

import net.somta.springboot.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("net.somta.springboot.mapper")
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void addUser() {
        User user = new User();
        user.setId(66L);
        user.setAge(39);
        user.setName("zhansan");
        int count = userMapper.addUser(user);
        Assertions.assertEquals(1,count);
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void updateUserById() {
    }

    @Test
    void queryUserById() {
        User user = userMapper.queryUserById(66L);
        System.out.println("根据ID=66获取到的用户为:"+user);
        Assertions.assertEquals("zhansan",user.getName());
    }

    @Test
    void queryUserList() {
        List<User> list = userMapper.queryUserList();
        list.forEach(u -> System.out.println(u));
    }
}