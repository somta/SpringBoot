/*
package com.somta.springboot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somta.springboot.Application;
import com.somta.springboot.dao.UserDao;
import com.somta.springboot.pojo.User;


*/
/**
 * 
 * @author 明天的地平线
 * 
 * SpringBoot 之前的版本配置单元测试类时使用 @SpringApplicationConfiguration(Application.class)
 * SpringBoot 1.5.9  改用@SpringBootTest(classes = Application.class)
 * 
 *
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MyBatisTest {

	
	@Autowired
	private UserDao userDao;
	
	*/
/**
	 * 新增用户
	 * @throws Exception
	 *//*

	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setId(889L);
		user.setName("zhangsan");
		user.setAge(12);
		userDao.addUser(user);
	}
	
	*/
/**
	 * 删除用户
	 * @throws Exception
	 *//*

	@Test
	public void testDelUser() throws Exception {
		userDao.deleteUserById(889L);
	}
	
	*/
/**
	 * 修改用户信息
	 * @throws Exception
	 *//*

	@Test
	public void testUpdUser() throws Exception {
		User user = new User();
		user.setId(2L);
		user.setName("zhangsan99");
		user.setAge(122);
		userDao.updateUserById(user);
	}
	
	*/
/**
	 * 查询用户
	 * @throws Exception
	 *//*

	@Test
	public void testQueryUser() throws Exception {
		User user = userDao.queryUserById(2L);
		System.out.println(user.getName());
	}
	
	*/
/**
	 * 查询所有用户
	 * @throws Exception
	 *//*

	@Test
	public void testQueryUserList() throws Exception {
		List<User> list = userDao.queryUserList();
		for (User user : list) {
			System.out.println(user.getName());
		}
	}
	
}
*/
