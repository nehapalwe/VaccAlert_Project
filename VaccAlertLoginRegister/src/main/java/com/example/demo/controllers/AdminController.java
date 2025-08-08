package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminRegisterDTO;
import com.example.demo.entities.Login;
import com.example.demo.services.AdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
	
	@Autowired
    private AdminService adminService;

    @PostMapping("/registerAdmin")
    public Login registerAdmin(@RequestBody AdminRegisterDTO dto) {
        return adminService.registerAdmin(dto);
    }
}
