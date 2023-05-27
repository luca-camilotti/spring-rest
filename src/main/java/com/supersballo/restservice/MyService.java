package com.supersballo.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	private final MyRepository repo;
	@Autowired 
	public MyService(MyRepository rp) {
		this.repo = rp;
	}

	public List<Employee> getEmployees() {
		return repo.findAll();
	}
	public Optional<Employee> getById(int id) {
		return repo.findById((long) id);
	}

	// Create a new employee
	public Employee addNewEmployee(Employee emp) {
		return repo.save(emp);  // use the repository built-in save() method
	}
	
	// Update an existing employee
	public Employee updateEmployee(Employee emp, long id) {
		if(repo.findById(id).isPresent()) {
			emp.setId(id);
			repo.save(emp);
			return emp;
		}
	    return null;
	}
}

