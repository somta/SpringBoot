package net.somta.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("net.somta.springboot.mapper")
@SpringBootApplication
public class Application {

	public static void main(String [] args) {
		SpringApplication.run(Application.class, args);
    }
}
