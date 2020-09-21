package com.website.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.website.model.User;

@Service
public interface UserService {
	
	public User register(User user);

	public List<User> usersList();

	public User login(String username, String password);

}
