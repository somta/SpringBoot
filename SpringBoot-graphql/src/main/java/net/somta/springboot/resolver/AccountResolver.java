package net.somta.springboot.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import net.somta.springboot.model.Account;
import net.somta.springboot.model.Role;
import net.somta.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountResolver implements GraphQLResolver<Account> {

    @Autowired
    private RoleService roleService;

    /**
     * 只有
     * 要 account.graphqls Account中的roles属性一样 格式 get + roles 驼峰格式
     * @param account
     * @return
     */
    public List<Role> getRoles(Account account){
        System.out.println("调用了AccountResolver");
        return roleService.getRolesByUid(account.getId());
    }

}
