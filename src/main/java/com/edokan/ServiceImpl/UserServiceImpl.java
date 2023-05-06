package com.edokan.ServiceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edokan.Entity.User;
import com.edokan.Repositiry.UserRepository;
import com.edokan.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	 @Autowired
	  private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User getUser(String userName) {
		return userRepo.findByUserName(userName);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User saveUser(User user) {
		System.out.println("UserserviceImpl saveUser method..");
		String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
		return userRepo.save(user);
	}

	
	

}
