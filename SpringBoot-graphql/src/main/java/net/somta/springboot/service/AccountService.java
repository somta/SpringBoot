package net.somta.springboot.service;

import net.somta.springboot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> list = new ArrayList<>();

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void initData(){
        roleService.getRolesByUid(1);
        list.add(new Account(1,"张三",15,roleService.getRolesByUid(1)));
        list.add(new Account(2,"李四",17,roleService.getRolesByUid(2)));
        list.add(new Account(3,"王五",30,roleService.getRolesByUid(3)));
    }

    public List<Account> getAccountList(){
        return list;
    }

    public Account getAccountById(Integer id){
        return list.stream().filter(a->a.getId() == id).findFirst().get();
    }
}
