package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
public class FirstController {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository urepo;
	
	@GetMapping("/public")
	public String publicroute() {
		return "For all";		
	}

	@GetMapping("/admin")
	public String adminroute() {
		return "For admin";		
	}
	
	@GetMapping("/user")
	public String userroute() {
		return "For user";		
	}
	
	//save operation
	@PostMapping("/register")
	public boolean register(@RequestBody User u) {
		System.out.println(u.getUsername()+" : "+u.getPassword()+" : "+u.getRoles());
		u.setPassword(encoder.encode(u.getPassword()));
		System.out.println(u.getUsername()+" : "+u.getPassword()+" : "+u.getRoles());
		try{
			urepo.save(u);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}


}
