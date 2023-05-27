package com.supersballo.restservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByFirstName(String name);
	List<Employee> findByFirstNameIgnoringCase(String name);
	List<Employee> findByFirstNameOrLastName(String name, String surname);
	List<Employee> findByFirstNameOrLastNameAllIgnoringCase(String name, String surname);
	List<Employee> findByFirstNameOrLastNameOrderByLastNameAsc(String name, String surname);

}

