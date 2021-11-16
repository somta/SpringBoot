package com.somta.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somta.springboot.Application;
import com.somta.springboot.dao.master.UserMasterDao;
import com.somta.springboot.dao.slaver.UserSlaverDao;
import com.somta.springboot.pojo.User;


/**
 * 
 * @author 明天的地平线
 * 
 * SpringBoot 之前的版本配置单元测试类时使用 @SpringApplicationConfiguration(Application.class)
 * SpringBoot 1.5.9  改用@SpringBootTest(classes = Application.class)
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MultiDatasourceTest {

	
	@Autowired
	private UserMasterDao masterUserDao;
	
	@Autowired
	private UserSlaverDao slaverUserDao;

	
	/**
	 * 查询用户
	 * @throws Exception
	 */
	@Test
	public void testQueryUser() throws Exception {
		User masterUser = masterUserDao.queryUserById(1L);
		System.out.println("masterUser==>"+masterUser.getName());
		
		User slaverUser = slaverUserDao.queryUserById(1L);
		System.out.println("slaverUser==>"+slaverUser.getName());
	}
	
	
	
}
