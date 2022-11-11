package com.tejas.spotifyapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableEurekaClient
//@CrossOrigin(origins = "http://localhost:4200")
public class SpotifyapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyapigatewayApplication.class, args);
	}
}
