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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edokan.Entity.Employee;
import com.edokan.Entity.User;
import com.edokan.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/health")
	public String health()
	{
		logger.info("inside health controller");
		return "Application wokring!!!..";
	}

	@GetMapping("/getAllUser")
	public List<User> getAllEmployee()
	{
		logger.info("inside getAllEmployee controller");
		return userService.getAllUser();
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<User> getEmployee(@PathVariable String userName)
	{
		logger.info("inside get employee by id controller");
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userName));
	}
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateEmployee(@RequestBody User user)
	{
		logger.info("inside update employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveEmployee(@RequestBody User user)
	{
		logger.info("inside save employee method!!!!");
		return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
	}
	

}
