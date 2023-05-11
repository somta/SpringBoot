package net.somta.springboot.derby.mapper;

import net.somta.springboot.derby.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @throws Exception
     */
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setId(889L);
        user.setName("zhangsan");
        user.setAge(12);
        userMapper.addUser(user);
    }
}