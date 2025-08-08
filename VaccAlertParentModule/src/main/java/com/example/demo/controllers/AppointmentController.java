package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AppointmentRequest;
import com.example.demo.entities.Child;
import com.example.demo.entities.ChildVaccinationRecord;
import com.example.demo.entities.Hospital;
import com.example.demo.services.AppointmentService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AppointmentController {
	
	 @Autowired
	    AppointmentService appointmentService;

	    @GetMapping("/children")
	    public List<Child> getChildren(@RequestParam int parentId) {
	        return appointmentService.getChildrenByParentId(parentId);
	    }
	    
	    @GetMapping("/hospitals")
	    public List<Hospital> getAllHospitals() {
	        return appointmentService.getAllHospitals();
	    }
	    
	    @GetMapping("/hospitalByName")
	    public List<Hospital> getHospitalsByName(@RequestParam String name) {
	        return appointmentService.getHospitalsByName(name);
	    }

	    @PostMapping("/bookAppointment")
	    public ChildVaccinationRecord bookAppointment(@RequestBody AppointmentRequest req) {
	        return appointmentService.bookAppointment(req);
}
}