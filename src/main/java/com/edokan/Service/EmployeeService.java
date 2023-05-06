package com.edokan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edokan.Entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	Optional<Employee> getEmployee(Integer id);
	
	Employee updateEmployee(Employee emp);

	Employee saveEmployee(Employee emp);

	
	

}
