package com.somta.springboot.web.controller;

import com.somta.springboot.configuration.LogStore;
import com.somta.springboot.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Description:
 * @Date: 2019/9/5
 * @Author: 明天的地平线
 * @Blog: https://somta.com.cn/index
 * @Version: 1.0.0
 */
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

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
	    return user;
    }

    /**
     *  测试可插拔的方法级别的日志记录
     * @param user
     * @return
     */
    @LogStore
    @PostMapping("/addUserByAnnotation")
    public User addUserByAnnotation(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        return user;
    }
	
}
