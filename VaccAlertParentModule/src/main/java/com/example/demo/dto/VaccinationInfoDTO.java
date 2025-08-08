package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccinationInfoDTO {
	
	private String childName;
    private Date dateGiven;       // For history
    private Date nextDueDate;     // For upcoming
    private String hospitalName;
    private String vaccineName;
    
    
	public VaccinationInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationInfoDTO(String childName, Date dateGiven, Date nextDueDate, String hospitalName,
			String vaccineName) {
		super();
		this.childName = childName;
		this.dateGiven = dateGiven;
		this.nextDueDate = nextDueDate;
		this.hospitalName = hospitalName;
		this.vaccineName = vaccineName;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public Date getDateGiven() {
		return dateGiven;
	}
	public void setDateGiven(Date dateGiven) {
		this.dateGiven = dateGiven;
	}
	public Date getNextDueDate() {
		return nextDueDate;
	}
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
    
    
    
}
