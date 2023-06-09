package com.supersballo.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
      return "Hello World!";
   }
   @GetMapping( "/test" )
	public List<String> welcome() {
		return List.of("Welcome", "Docker", "Spring Boot");
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
   
   /* Delete employee
    * */
   @DeleteMapping("/employees/{id}")
   public void deleteEmployee(@PathVariable int id) {
      service.deleteEmployee(id);
   }

}
