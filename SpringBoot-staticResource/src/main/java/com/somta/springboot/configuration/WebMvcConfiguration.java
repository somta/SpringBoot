package com.somta.springboot.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;;

/**
 * @Description: 在SpringBoot2.0之前静态资源的访问，和权限拦截都是通过继承WebMvcConfigurerAdapter来实现的
 *                 SpringBoot2.0后需要通过实现接口来配置了
 * @Date: 2019/4/24
 * @Author: 明天的地平线
 * @Blog: https://somta.com.cn/index
 * @Version: 1.0.0
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
    }
}
