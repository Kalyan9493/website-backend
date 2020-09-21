package com.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.User;
import com.website.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@GetMapping("/")
	public List<User> usersList(){
		return userService.usersList();
	}
	@GetMapping("/login")
	public HttpStatus login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password ) {
	    User user = userService.login(username, password);
	    if(user != null) {
	    	return HttpStatus.ACCEPTED;	
	    }else {
	    	return HttpStatus.UNAUTHORIZED;
	    }
	}

}
