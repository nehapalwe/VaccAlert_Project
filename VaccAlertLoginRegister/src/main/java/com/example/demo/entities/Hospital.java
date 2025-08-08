package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private int hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "registration_number")
    private String registrationNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Login userId;

    @Column(name = "address")
    private String address;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String hospitalName, String registrationNumber, Login userId, String address) {
		super();
		this.hospitalName = hospitalName;
		this.registrationNumber = registrationNumber;
		this.userId = userId;
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

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Login getUserId() {
		return userId;
	}

	public void setUserId(Login userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
    
    

}
