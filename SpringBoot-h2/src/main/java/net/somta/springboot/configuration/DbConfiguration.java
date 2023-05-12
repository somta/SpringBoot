package net.somta.springboot.configuration;

import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;


/**
 *
 * DB配置类
 *
 * @Date:        2021-02-03
 * @Author:      husong
 * @Version:     1.0.0
 */
@Configuration
public class DbConfiguration {


    @Primary
    @Bean
    public SqlInitializationProperties sqlInitializationProperties(){
        SqlInitializationProperties sqlInitializationProperties = new SqlInitializationProperties();
        sqlInitializationProperties.setSchemaLocations(Arrays.asList("classpath:db/schema.sql"));
        sqlInitializationProperties.setDataLocations(Arrays.asList("classpath:db/data.sql"));
        sqlInitializationProperties.setMode(DatabaseInitializationMode.ALWAYS);
        // 文件模式下，每次启动都会执行初始化，应该要跳过错误，表的初始化还是应该通过maven插件来做 https://www.jianshu.com/p/4a613dcf182c
        sqlInitializationProperties.setContinueOnError(true);
        return sqlInitializationProperties;
    }

}
