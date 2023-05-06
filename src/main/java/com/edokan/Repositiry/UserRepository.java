package com.edokan.Repositiry;

import org.springframework.data.repository.CrudRepository;

import com.edokan.Entity.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	User findByUserName(String userName);

}
