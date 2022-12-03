package net.somta.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO 类职责描述
 *
 * @author husong
 * @date 2022/12/03
 */
@MapperScan("net.somta.springboot.mapper")
@Configuration
public class ApplicationConfig {
}
