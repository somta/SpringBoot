package net.somta.springboot.mapper.noboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * H2的一个很重要的使用场景就是做MyBatis的单元测试，直接使用H2的内存数据库，使用完毕直接释放
 * 不启动SpringBoot使用H2数据库进行单元测试
 */
class CommonTest extends BaseRepositoryTest2{

    @Value("${somta.name}")
    private String name;

    /**
     * 测试是否获取正确的配置文件
     */
    @Test
    void configTest() {
        System.out.println(name);
    }


}