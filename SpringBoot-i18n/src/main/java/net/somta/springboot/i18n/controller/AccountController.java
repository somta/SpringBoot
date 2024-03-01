package net.somta.springboot.i18n.controller;

import net.somta.springboot.i18n.base.ResponseData;
import net.somta.springboot.i18n.enums.AccountErrorEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(value = "/getAccountType")
    public ResponseData<String> getAccountType() {
        if(true){
            return ResponseData.setErrorResponseData(AccountErrorEnum.ACCOUNT_TYPE);
        }

        return ResponseData.setResponseData("");
    }

}
