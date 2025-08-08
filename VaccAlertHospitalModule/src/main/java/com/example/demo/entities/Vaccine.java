package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccines")
public class Vaccine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private int vaccineId;

    @Column(name = "vaccine_name")
    private String vaccineName;
    
	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vaccine(int vaccineId, String vaccineName) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
    
}
