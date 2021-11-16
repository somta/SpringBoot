package com.somta.springboot.web.controller;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pub")
public class LogConttoller {
	
	private final static Logger logger = LoggerFactory.getLogger(LogConttoller.class);
   
	@GetMapping("/getLog")
	public String getLog(){  
        logger.debug("This is a debug message");  
        logger.info("This is an info message");  
        logger.warn("This is a warn message");  
        logger.error("This is an error message"); 
        return "log....";
    }  
	
}
