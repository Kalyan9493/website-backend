package com.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.website.model.User;
import com.website.repository.UserRepository;
import com.website.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	public User register(User user) {
		
		String passwd=	user.getPassword();
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(passwd));
		return userRepository.save(user);
		
	}

	@Override
	public List<User> usersList() {
		return userRepository.findAll();
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
