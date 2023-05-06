package com.edokan.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edokan.Entity.Employee;
import com.edokan.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/health")
	public String health()
	{
		logger.info("inside health controller");
		return "Application wokring!!!..";
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployee()
	{
		logger.info("inside getAllEmployee controller");
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Integer id)
	{
		logger.info("inside get employee by id controller");
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
	}
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		logger.info("inside update employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(emp));
	}
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		logger.info("inside save employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(emp));
	}
	
	
}
