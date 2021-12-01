package net.somta.springboot.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import net.somta.springboot.model.Account;
import net.somta.springboot.model.AccountVO;
import net.somta.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private AccountService accountService;

    public Account addAccount(AccountVO accountVO){
        return accountService.addAccount(accountVO);
    }
}
