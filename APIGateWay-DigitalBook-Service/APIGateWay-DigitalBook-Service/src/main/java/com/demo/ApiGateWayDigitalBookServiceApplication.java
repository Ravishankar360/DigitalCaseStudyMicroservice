package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGateWayDigitalBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayDigitalBookServiceApplication.class, args);
	}

}
