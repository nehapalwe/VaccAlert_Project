package com.example.demo.dto;

import java.util.Date;

public class AppointmentView {
	
	private String childName;
	private Date dob;
    private String gender;
    private String medicalHistory;
    private String bloodGroup;
    private String parentFirstName;
    private String parentLastName;
    private String parentEmail;
    private String parentContact;
    private String vaccineName;
    private Date nextDueDate;
    
    
	public AppointmentView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentView(String childName,Date dob, String gender, String medicalHistory, String bloodGroup, String parentFirstName,
			String parentLastName, String parentEmail, String parentContact, String vaccineName, Date nextDueDate
) {
		super();
		this.childName = childName;
		this.dob = dob;
		this.gender = gender;
		this.medicalHistory = medicalHistory;
		this.bloodGroup = bloodGroup;
		this.parentFirstName = parentFirstName;
		this.parentLastName = parentLastName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
		this.vaccineName = vaccineName;
		this.nextDueDate = nextDueDate;
		
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getParentFirstName() {
		return parentFirstName;
	}
	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}
	public String getParentLastName() {
		return parentLastName;
	}
	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}
	public String getParentEmail() {
		return parentEmail;
	}
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}
	public String getParentContact() {
		return parentContact;
	}
	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public Date getNextDueDate() {
		return nextDueDate;
	}
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
	
    
    
    

	
    
}
