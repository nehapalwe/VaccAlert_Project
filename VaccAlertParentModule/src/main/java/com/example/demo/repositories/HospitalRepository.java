package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	List<Hospital> findByHospitalName(String name);
}
