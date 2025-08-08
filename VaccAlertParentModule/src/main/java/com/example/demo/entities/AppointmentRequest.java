package com.example.demo.entities;

import java.util.Date;

public class AppointmentRequest {
	
	private int childId;
    private int hospitalId;
    private Date appointmentDate;
    
    
	public AppointmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentRequest(int childId, int hospitalId, Date appointmentDate) {
		super();
		this.childId = childId;
		this.hospitalId = hospitalId;
		this.appointmentDate = appointmentDate;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
    
    
}
