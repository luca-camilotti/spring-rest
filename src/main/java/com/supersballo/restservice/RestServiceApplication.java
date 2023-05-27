package com.supersballo.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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

}
