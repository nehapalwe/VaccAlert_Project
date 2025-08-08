package com.example.demo.dto;

public class ParentRegisterDTO {
	
	private String name;
    private String password;
    private String email;
    private String contactNo;

    private String aadharNumber;
    private String address;
    private String firstName;
    private String lastName;
    private String occupation;
    
    
    
	public ParentRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParentRegisterDTO(String name, String password, String email, String contactNo, String aadharNumber,
			String address, String firstName, String lastName, String occupation) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
    
    
}
