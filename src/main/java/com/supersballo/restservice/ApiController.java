package com.supersballo.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final MyService service;

	@Autowired
	public ApiController(MyService srv) {
		this.service = srv;
	}

	@RequestMapping( "/hello" )
	public String echo() {
		return "Hello Rest Spring Boot!";
	}
	@GetMapping( "/test" )
	public List<String> welcome() {
		return List.of("Welcome", "Docker", "Spring Boot");
	}
	@GetMapping("/error")
	public void error() {
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "error test: entity not found"
				);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}

	/* Path variable example (id)
	 * If the path variable and the method variable
	 * have the same name, you can just use the
	 * @PathVariable decoration without explicitly 
	 * type the path variable inside parenthesis, so
	 * @PathVariable("id") becomes @PathVariable
	 * */
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
		return service.getById(id);
	}

	/* Managing post requests (example) 
	 * This method adds a new employee 
	 * to the database.
	 * 
	 * */
	@PostMapping("/employees")
	public Employee registerNewEmployee(@RequestBody Employee emp) {
		return service.addNewEmployee(emp);
	}

	/* Update employee
	 * */
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		return service.updateEmployee(emp, id);
	}

	/* Delete employee (original version)
	 * */
	/*
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	} */
	
	/* Delete employee (modified version)
	 * */
	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		Optional<Employee> emp = service.deleteEmployeeIfPresent(id);
		if(!emp.isPresent())
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "entity not found"
					);
		return emp.get();
	}
}
