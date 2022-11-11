package com.tejas.spotifyapigateway.config;

import com.tejas.spotifyapigateway.filter.JWTFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.ws.rs.HttpMethod;

@Configuration
//@CrossOrigin(origins = "http://localhost:4200")
public class AppConfig {
	private static final String GET="GET";
	private static final String POST="POST";
	private static final String DELETE="DELETE";
	private static final String PUT="PUT";

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route(p->p.path("/api/v1/user-song-service/**").uri("lb://USER-SONG-SERVICE"))
                .route(p->p.path("/api/v2/user-login/**").uri("lb://LOGIN-SERVICE"))
				.route(p->p.path("/api/v3/spotify-songs/**").uri("lb://SONG-SERVICE"))
                .build();
    }

    @Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JWTFilter());
		filterRegistrationBean.addUrlPatterns("/api/v2/user-login/users");
		return filterRegistrationBean;
	}

	@Bean

	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods(GET,POST,DELETE,PUT)
						.allowedHeaders("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true)
						;
			}
		};
	}
}
