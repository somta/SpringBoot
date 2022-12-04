package net.somta.springboot.mapper;

import net.somta.springboot.model.User;
import net.somta.springboot.model.params.UserParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void add(User user);

    List<User> queryByList(UserParams userParams);

}
