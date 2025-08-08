package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

}
