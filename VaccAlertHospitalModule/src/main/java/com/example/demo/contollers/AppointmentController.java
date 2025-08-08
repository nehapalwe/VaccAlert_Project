package com.example.demo.contollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentView;
import com.example.demo.services.AppointmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppointmentController {
	
	@Autowired
    AppointmentService appointmentService;

    @GetMapping("/viewAppointments")
    public List<AppointmentView> viewAppointments(@RequestParam("hospitalId") int hospitalId) {
        return appointmentService.getAppointmentsForHospital(hospitalId);
    }
}
