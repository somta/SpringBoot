package net.somta.springboot.webservice;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceApplication {

	public static void main(String [] args) {
		SpringApplication.run(WebServiceApplication.class, args);
    }

}
