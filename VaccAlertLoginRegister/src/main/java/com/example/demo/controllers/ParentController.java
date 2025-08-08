package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParentRegisterDTO;
import com.example.demo.entities.Login;
import com.example.demo.entities.Parent;
import com.example.demo.services.LoginService;
import com.example.demo.services.ParentService;

@CrossOrigin(origins="http://localhost:3000")

@RestController

public class ParentController {
	
	@Autowired
	ParentService pservice;
	
	@Autowired
	LoginService lservice;

	
	@GetMapping("/getParent")
	public Parent getParent(@RequestParam("userId") int userId) {
		
		Login u = lservice.getById(userId);
		return pservice.getParent(u);
	}
	
	@PostMapping("/registerParent")
    public Parent registerParent(@RequestBody ParentRegisterDTO dto) {
        return pservice.registerParent(dto);
    }
}
