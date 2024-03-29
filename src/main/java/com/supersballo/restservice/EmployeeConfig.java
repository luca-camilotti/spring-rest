package com.supersballo.restservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * This bean is created to fill the database table
 * with some record
 * */

@Configuration
public class EmployeeConfig {
	@Bean 
	CommandLineRunner commandLineRunner(MyRepository repo) {
		return args -> {
			Employee john = new Employee((long) 0, "Jonh", "De Pippi", 1500, "developer", "john.depippi@gmail.com", 5, LocalDate.of(2003,  2, 22));
			Employee jack = new Employee((long) 0, "Jack", "Paperonis", 1720, "developer", "jack.paperonis@gmail.com", 7, LocalDate.of(2005,  5, 7));
			Employee jim = new Employee((long) 0, "James T.", "Kirk", 2150, "captain", "jim.kirk@gmail.com", 7, LocalDate.of(2001,  3, 21));
			Employee bones = new Employee((long) 0, "Leonard", "McCoy", 1450, "doctor", "bones.mccoy@gmail.com", 7, LocalDate.of(1999,  8, 11));
			repo.saveAll(List.of(john, jack, jim, bones)); // save to database
		};
	}
}

