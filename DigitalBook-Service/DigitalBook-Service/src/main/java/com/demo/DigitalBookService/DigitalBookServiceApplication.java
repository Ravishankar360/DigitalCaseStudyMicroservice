package com.demo.DigitalBookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableEurekaClient
public class DigitalBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookServiceApplication.class, args);
	}

}
