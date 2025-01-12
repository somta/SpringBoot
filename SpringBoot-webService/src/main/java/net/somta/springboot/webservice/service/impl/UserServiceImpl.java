package net.somta.springboot.webservice.service.impl;
import net.somta.springboot.webservice.model.User;
import net.somta.springboot.webservice.model.UserParam;
import net.somta.springboot.webservice.service.UserService;
import org.springframework.stereotype.Service;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

//@WebService(serviceName="userService",//对外发布的服务名
//        targetNamespace="http://service.webservice.springboot.somta.net/",//指定你想要的名称空间，通常使用使用包名反转,最后要带一个/
//        endpointInterface="net.somta.springboot.webservice.service.UserService")//这个必须是接口类的完整的类路径
@Service
@WebService(serviceName="userService",targetNamespace="http://service.webservice.springboot.somta.net/")
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();
    public UserServiceImpl() {
        User user = new User();
        user.setId("111");
        user.setUserName("test1");

        userMap.put(user.getId(), user);

        user = new User();
        user.setId("112");
        user.setUserName("test2");
        userMap.put(user.getId(), user);

        user = new User();
        user.setId("113");
        user.setUserName("test3");
        userMap.put(user.getId(), user);
    }

    @Override
    public User addUser(UserParam userParam) {
        User user = new User();
        user.setId(userParam.getId());
        user.setUserName(userParam.getUserName());
        userMap.put(userParam.getId(),user);
        return user;
    }

    @Override
    public User getUser(String userId) {
        User user = new User();
        user.setId(userId);
        user.setUserName("testUser");
        return user;
    }
}