package com.edokan.Repositiry;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edokan.Entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	Optional<Employee> findById(Integer id);


	
}
