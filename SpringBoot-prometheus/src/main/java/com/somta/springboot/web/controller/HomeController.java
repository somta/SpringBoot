package com.somta.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songhu on 2020/5/17.
 */
@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
