package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Hospital;
import com.example.demo.entities.Login;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	@Query("select h from Hospital h where userId= :u")
	public Hospital getHospital(Login u);
	
}
