package net.somta.springboot.service;

import net.somta.springboot.model.Account;
import net.somta.springboot.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private List<Role> list = new ArrayList<>();

    @PostConstruct
    public void initData(){
        list.add(new Role(1,"角色1",1));
        list.add(new Role(2,"角色2",2));
        list.add(new Role(3,"角色2",2));
    }

    public List<Role> getRoleList(){
        return list;
    }

    public List<Role> getRolesByUid(Integer userId){
        return list.stream().filter(r -> r.getUserId() == userId).collect(Collectors.toList());
    }
}
