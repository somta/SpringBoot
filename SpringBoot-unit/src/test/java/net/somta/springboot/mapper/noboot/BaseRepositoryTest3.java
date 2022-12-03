package net.somta.springboot.mapper.noboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @desc: Repository测试的基础父类
 * @author: husong
 * @date: 2022/12/5
 **/
@SpringBootTest
@MapperScan("net.somta.springboot.mapper")
public class BaseRepositoryTest3 {
}
