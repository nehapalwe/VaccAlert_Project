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
@Table(name="parents")
public class Parent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	int parentId;
	
	@Column(name="aadhar_number")
	String aadharNumber;
	
	@Column(name="address")
	String address;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;

	@Column(name="occupation")
	String occupation;
	
	@OneToOne
	@JoinColumn(name="user_id")
	Login userId;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(int parentId, String aadharNumber, String address, String firstName, String lastName,
			String occupation, Login userId) {
		super();
		this.parentId = parentId;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.userId = userId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Login getUserId() {
		return userId;
	}

	public void setUserId(Login userId) {
		this.userId = userId;
	}
	
	
}
