package net.somta.springboot.mapper;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @desc: Repository测试的基础父类
 * @author: husong
 * @date: 2022/12/5
 **/
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        ShardingSphereAutoConfiguration.class,
        //DataSourceAutoConfiguration.class,
        //MybatisAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        //MapperAutoConfiguration.class,
        //PageHelperAutoConfiguration.class
        })
@TestPropertySource(locations = {"/application-unit.properties"})
public class BaseShardingSphereRepositoryTest {
}
