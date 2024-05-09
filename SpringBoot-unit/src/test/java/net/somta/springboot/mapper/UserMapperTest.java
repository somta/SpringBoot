//package net.somta.springboot.mapper;
//
//import net.somta.springboot.pojo.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.SqlConfig;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.xml.ws.soap.Addressing;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {
//        DataSourceTransactionManagerAutoConfiguration.class
//})
//@TestPropertySource(locations = {"/application-unit.properties"},
//        properties = {
//                "mybatis.mapperLocations=classpath*:mybatis/**/Mysql_*Mapper.xml"
//        })
//@MapperScan("com.somta.*.*.mapper")
//@Sql(scripts="file:../db/schema.sql",config=@SqlConfig(encoding = "utf-8"))
//class UserMapperTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    void addUser() {
//        User user = new User();
//        user.setName("明天的地平线");
//        user.setAge(18);
//        userMapper.addUser(user);
//    }
//
//    @Test
//    void deleteUserById() {
//    }
//
//    @Test
//    void updateUserById() {
//    }
//
//    @Test
//    void queryUserById() {
//    }
//
//    @Test
//    void queryUserList() {
//    }
//}