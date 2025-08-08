package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Hospital;
import com.example.demo.entities.Login;
import com.example.demo.repositories.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hrepo;
	
	public Hospital getHospital(Login u) {
		
		return hrepo.getHospital(u);
	}
	
	public Hospital saveHospital(Hospital h) {
		return hrepo.save(h);
	}

}
