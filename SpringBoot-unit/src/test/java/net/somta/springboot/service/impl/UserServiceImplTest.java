package net.somta.springboot.service.impl;

import net.somta.springboot.mapper.UserMapper;
import net.somta.springboot.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @InjectMocks
    @Spy
    private UserServiceImpl userService;
    @Mock
    private UserMapper userMapper;

    UserServiceImplTest() {
    }

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUser() {
        try {
            userService.addUser(null);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }

        User user = new User();
        user.setName("明天的地平线");
        user.setAge(18);
        Mockito.when(userMapper.addUser(user)).thenReturn(1);
        userService.addUser(user);
    }

    @Test
    void getUserById() {
    }
}