package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="child_vaccination_record")
public class ChildVaccinationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="child_vaccine_id")
    int childVaccineId;

    @ManyToOne
    @JoinColumn(name="child_id")
    Child childId;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    Hospital hospitalId;

    @ManyToOne
    @JoinColumn(name="vaccine_id")
    Vaccine vaccineId;
 // Optional for booking

    @Column(name="dategiven")
    Date dateGiven;

    @Column(name="nextduedate")
    Date nextDueDate;

	public ChildVaccinationRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChildVaccinationRecord(int childVaccineId, Child childId, Hospital hospitalId, Vaccine vaccineId,
			Date dateGiven, Date nextDueDate) {
		super();
		this.childVaccineId = childVaccineId;
		this.childId = childId;
		this.hospitalId = hospitalId;
		this.vaccineId = vaccineId;
		this.dateGiven = dateGiven;
		this.nextDueDate = nextDueDate;
	}

	public int getChildVaccineId() {
		return childVaccineId;
	}

	public void setChildVaccineId(int childVaccineId) {
		this.childVaccineId = childVaccineId;
	}

	public Child getChildId() {
		return childId;
	}

	public void setChildId(Child childId) {
		this.childId = childId;
	}

	public Hospital getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Hospital hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Vaccine getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Vaccine vaccineId) {
		this.vaccineId = vaccineId;
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

	
    

}
