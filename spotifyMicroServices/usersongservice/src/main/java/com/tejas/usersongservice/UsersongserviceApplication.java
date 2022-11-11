package com.tejas.usersongservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class UsersongserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersongserviceApplication.class, args);
	}

}
