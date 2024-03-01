package net.somta.springboot.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/getI18nMessage")
    public String getI18nMessage() {
        // 获取客户端的语言环境Locale对象，即取的请求头Accept-Language键的值来判断，我们也可以自定义请求头键，来获取语言标识
        Locale locale = LocaleContextHolder.getLocale();
        String language = locale.getLanguage();
        System.out.println("语言："+language);
        String userName = messageSource.getMessage("user.userName", null, locale);
        System.out.println(userName);
        return userName;
    }

}
