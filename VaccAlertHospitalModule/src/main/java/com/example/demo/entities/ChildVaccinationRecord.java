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
	@Table(name = "child_vaccination_record")
	public class ChildVaccinationRecord {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "child_vaccine_id")
	    private int childVaccineId;

	    @ManyToOne
	    @JoinColumn(name = "child_id")
	    private Child childId;

	    @ManyToOne
	    @JoinColumn(name = "hospital_id")
	    private Hospital hospitalId;

	    @ManyToOne
	    @JoinColumn(name = "vaccine_id")
	    private Vaccine vaccineId;

	    @Column(name = "dategiven")
	    private Date dateGiven;

	    @Column(name = "nextduedate")
	    private Date nextDueDate;
	    
	    

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

		public Child getChild() {
			return childId;
		}

		public void setChild(Child childId) {
			this.childId = childId;
		}

		public Hospital getHospital() {
			return hospitalId;
		}

		public void setHospital(Hospital hospitalId) {
			this.hospitalId = hospitalId;
		}

		public Vaccine getVaccine() {
			return vaccineId;
		}

		public void setVaccine(Vaccine vaccineId) {
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
