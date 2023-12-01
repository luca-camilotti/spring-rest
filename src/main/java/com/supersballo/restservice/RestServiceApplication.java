package com.supersballo.restservice;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 * IMPORTANT:
 * All classes must be inside the application package or in a sub-package.
 * Otherwise you should specify the package to scan with @ComponentScan annotation, i.e.:
 * @ComponentScan("com.supersballo.restservice")
 * 
 * The (empty) JPA database must be created before starting the application.
 * 
 * Do not include Spring Security as a dependency in start.spring.io.
 * 
 * To produce the jar, click on project -> Run as -> Maven install
 * To run the app, click on project -> Run as -> Maven Build ->
 * -> Edit Goals field and type: spring-boot:run
 * (if you update the sources, the running program will be updated automatically)
 * 
 * You will find the running application on http://localhost:8080/
 * Example: http://localhost:8080/api/employees
 * */

// @ComponentScan("com.supersballo.restservice")
@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
	
	/* The following bean has the purpose to enable CORS requests.
	 * Type the allowed domains with setAllowedOrigins method  */
	@Bean
	public CorsFilter corsFilter() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    corsConfiguration.setAllowCredentials(true);
	    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:5173", "http://127.0.0.1:5173"));
	    corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
	"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	"Access-Control-Request-Method", "Access-Control-Request-Headers"));
	    corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
	"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	    return new CorsFilter(urlBasedCorsConfigurationSource);
	}


}
