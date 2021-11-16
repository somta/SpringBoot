package com.somta.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somta.springboot.pojo.User;
import com.somta.springboot.repository.UserRepository;


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
public class JpaTest {

	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 新增用户
	 * @throws Exception
	 */
	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setName("zhangsan");
		user.setAge(12);
		userRepository.save(user);
		
		User user2 = new User();
		user2.setName("lishi");
		user2.setAge(22);
		userRepository.save(user2);
	}
	
	/**
	 * 删除用户(根据对象删除时，必须要有ID属性)
	 * @throws Exception
	 */
	@Test
	public void testDelUser() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setName("zhangsan");
		user.setAge(12);
		userRepository.delete(user);
	}
	
	 
	/**
	 * 修改用户信息
	 * @throws Exception
	 */
	@Test
	public void testUpdUser() throws Exception {
		User user = new User();
		user.setId(2L);
		user.setName("zhangsan11");
		user.setAge(122);
		userRepository.save(user);
	}
	
	/**
	 * 查询用户
	 * @throws Exception
	 */
	@Test
	public void testQueryUser() throws Exception {
		User user = userRepository.findByAge(22);
		System.out.println(user.getName());
		
		User user2 = userRepository.findByNameAndAge("lishi", 22);
		System.out.println(user2.getName());
		
		User user3 = userRepository.findUser("zhangsan11");
		System.out.println(user3.getName());
	}
	
	/**
	 * 查询所有用户
	 * @throws Exception
	 */
	@Test
	public void testQueryUserList() throws Exception {
		List<User> list = userRepository.findAll();
		for (User user : list) {
			System.out.println(user.getName());
		}
	}
	
}
