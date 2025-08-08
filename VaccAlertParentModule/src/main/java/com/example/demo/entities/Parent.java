package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parents")
public class Parent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "aadhar_number", nullable = false, unique = true)
    private String aadharNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @OneToMany(mappedBy = "parentId")
    @JsonManagedReference
    private List<Child> children;

    public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(int parentId, String aadharNumber, String address, String firstName, String lastName,
			String occupation, List<Child> children) {
		super();
		this.parentId = parentId;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.children = children;
	}

	// Getters & Setters
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
