package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hospital_id")
    int hospitalId;

    @Column(name="hospital_name")
    String hospitalName;

    @Column(name="address")
    String address;

    
    
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hospitalId, String hospitalName, String address) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.address = address;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
