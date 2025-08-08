package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/all")
	public String all() {
		return "Response for all";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Response for user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Response for admin";
	}
}
