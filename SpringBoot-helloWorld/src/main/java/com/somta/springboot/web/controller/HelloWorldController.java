package com.somta.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/helloWorld")
    public String index() {
        return "HelloWorld";
    }
}
