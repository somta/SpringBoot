package net.somta.springboot.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import net.somta.springboot.model.Account;
import net.somta.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AccountService accountService;

    public List<Account> getAccountList(){
        return accountService.getAccountList();
    }

    public Account getAccountById(Integer id){
        return accountService.getAccountById(id);
    }

}
