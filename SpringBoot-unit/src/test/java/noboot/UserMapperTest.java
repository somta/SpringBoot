package noboot;

import net.somta.springboot.mapper.UserMapper;
import net.somta.springboot.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * H2的一个很重要的使用场景就是做MyBatis的单元测试，直接使用H2的内存数据库，使用完毕直接释放
 * 不启动SpringBoot使用H2数据库进行单元测试
 */
//@MapperScan("net.somta.springboot.mapper")
class UserMapperTest extends BaseRepositoryTest3 {

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