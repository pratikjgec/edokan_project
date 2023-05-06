package com.edokan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edokan.Entity.Employee;
import com.edokan.Entity.User;

@Service
public interface UserService {

	List<User> getAllUser();

	User  getUser(String userName);

	User updateUser(User user);

	User saveUser(User user);



}
