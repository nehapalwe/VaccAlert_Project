package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Hospital;
import com.example.demo.entities.HospitalReg;
import com.example.demo.entities.Login;
import com.example.demo.entities.Role;
import com.example.demo.services.HospitalService;
import com.example.demo.services.LoginService;
import com.example.demo.services.RoleService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class HospitalController {
	
	@Autowired
	HospitalService hservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	RoleService rservice;
	
	@GetMapping("/getHospital")
	public Hospital getHospital(@RequestParam("userId") int userId) {
		
		Login u = lservice.getById(userId);
		return hservice.getHospital(u);
	}
	
	@PostMapping("/regHospital")
	public Hospital regHospital(@RequestBody HospitalReg hr) {
		Role r = rservice.getRole(2);
		Login l = new Login(hr.getUname(), hr.getPassword(), hr.getEmail(), hr.getContact(),r,false);
		Login saved = lservice.save(l);
		
		Hospital h = new Hospital(hr.getHospitalname(), hr.getRegno(),saved,hr.getAddress());
		return hservice.saveHospital(h);
	}

}
