package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AppointmentView;
import com.example.demo.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
    AppointmentRepository appointmentRepository;

    public List<AppointmentView> getAppointmentsForHospital(int hospitalId) {
        return appointmentRepository.getAppointmentsByHospital(hospitalId);
   
}}
