package com.edokan.ServiceImpl;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edokan.Entity.Employee;
import com.edokan.Repositiry.EmployeeRepository;
import com.edokan.Service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return (List<Employee>) empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		
		return empRepo.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> empData=empRepo.findById(emp.getId());
		if(!empData.isPresent())
		{
			System.out.println("Emploee id="+emp.getId()+" does not exist");
			return null;
		}
		empRepo.save(emp);
		logger.info("Employee information updated!!!");
		return emp;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		
		Employee savedEmp=empRepo.save(emp);
		logger.info("Employee Saved in Database");
		return savedEmp;
	}
	
	

}
