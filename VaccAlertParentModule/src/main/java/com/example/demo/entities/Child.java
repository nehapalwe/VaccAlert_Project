package com.example.demo.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="child_id")
    int childId;

    @Column(name="child_name")
    String childName;

    @Column(name="dob")
    java.sql.Date dob;

    @Column(name="gender")
    String gender;

    @Column(name="blood_group")
    String bloodGroup;
    
    @Column(name="weight")
    private Double weight;
    
    @Column(name="height")
    private Double height;
    
    @Column(name="medical_history")
    String medicalHistory;

    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonBackReference
    Parent parentId;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child(int childId, String childName, Date dob, String gender, String bloodGroup, Double weight,
			Double height, String medicalHistory, Parent parentId) {
		super();
		this.childId = childId;
		this.childName = childName;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.weight = weight;
		this.height = height;
		this.medicalHistory = medicalHistory;
		this.parentId = parentId;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Parent getParentId() {
		return parentId;
	}

	public void setParentId(Parent parentId) {
		this.parentId = parentId;
	}
    
    
	
    
}

