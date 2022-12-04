package net.somta.springboot.mapper;

import net.somta.springboot.model.User;
import net.somta.springboot.model.params.UserParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

class UserMapperTest2 extends BaseShardingSphereRepositoryTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void add() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name"+i);
            user.setAge(12);
            userMapper.add(user);
        }
    }

    @Test
    void queryByList() {
        UserParams userParams = new UserParams();
        List<User> list = userMapper.queryByList(userParams);
        list.forEach(user -> System.out.println(user));
    }
}