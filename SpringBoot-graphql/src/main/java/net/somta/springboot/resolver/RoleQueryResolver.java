package net.somta.springboot.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import net.somta.springboot.model.Role;
import net.somta.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private RoleService roleService;

    public List<Role> getRoleList(){
        return roleService.getRoleList();
    }

    public List<Role> getRolesByUid(Integer userId){
        return roleService.getRolesByUid(userId);
    }

}
