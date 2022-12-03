package noboot;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @desc: Repository测试的基础父类
 * @author: husong
 * @date: 2022/12/5
 **/
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = {"/application-unit.properties"})
public class BaseRepositoryTest2 {
}
