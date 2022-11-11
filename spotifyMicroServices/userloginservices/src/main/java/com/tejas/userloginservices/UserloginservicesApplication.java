package com.tejas.userloginservices;

import com.tejas.userloginservices.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterRegistration;

@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:4200")
@EnableEurekaClient
@EnableHystrix
public class UserloginservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserloginservicesApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean jwtFilter()
//	{
//		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new JwtFilter());
//		filterRegistrationBean.addUrlPatterns("/api/v2/user-login/users");
//		return filterRegistrationBean;
//	}
}
