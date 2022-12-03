package noboot;

import net.somta.springboot.config.ApplicationConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @desc: Repository测试的基础父类
 * @author: husong
 * @date: 2022/12/5
 **/
@SpringBootTest
@TestPropertySource(locations = {"/application-unit.properties"},
                    properties = {"mybatis.mapperLocations=classpath*:mybatis/**/Mysql_*Mapper.xml"})
public class BaseRepositoryTest3 {
}
