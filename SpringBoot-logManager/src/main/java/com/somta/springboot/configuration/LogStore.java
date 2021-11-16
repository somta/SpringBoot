package com.somta.springboot.configuration;

import java.lang.annotation.*;

/**
 * @Description: 定义一个注解，将需要记录日志的请求方法，加上该注解
 * @Date: 2019/9/5
 * @Author: 明天的地平线
 * @Blog: https://somta.com.cn/index
 * @Version: 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogStore {
}
