package com.example.demo.dto;

public class AdminRegisterDTO {
	
	private String name;
    private String password;
    private String email;
    private String contactNo;
    
    
    
	public AdminRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminRegisterDTO(String name, String password, String email, String contactNo) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
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
    
    
}
