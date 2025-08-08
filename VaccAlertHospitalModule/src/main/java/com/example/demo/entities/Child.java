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
@Table(name = "child")
public class Child {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "child_id")
	    private int childId;

	    @ManyToOne
	    @JoinColumn(name = "parent_id")
	    private Parent parentId;

	    @Column(name = "child_name")
	    private String childName;

	    @Column(name = "dob")
	    private Date dob;

	    @Column(name = "gender")
	    private String gender;

	    @Column(name = "blood_group")
	    private String bloodGroup;

	    @Column(name = "medical_history")
	    private String medicalHistory;
	    
	    
	    
		public Child() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Child(int childId, Parent parentId, String childName, Date dob, String gender, String bloodGroup,
				String medicalHistory) {
			super();
			this.childId = childId;
			this.parentId = parentId;
			this.childName = childName;
			this.dob = dob;
			this.gender = gender;
			this.bloodGroup = bloodGroup;
			this.medicalHistory = medicalHistory;
		}

		public int getChildId() {
			return childId;
		}

		public void setChildId(int childId) {
			this.childId = childId;
		}

		public Parent getParent() {
			return parentId;
		}

		public void setParent(Parent parentId) {
			this.parentId = parentId;
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

		public String getBloodGroup() {
			return bloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

		public String getMedicalHistory() {
			return medicalHistory;
		}

		public void setMedicalHistory(String medicalHistory) {
			this.medicalHistory = medicalHistory;
		}
	    
}
