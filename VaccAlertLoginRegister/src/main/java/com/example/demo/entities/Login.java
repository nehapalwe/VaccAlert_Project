package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	int userId;
	
	@Column(name="name")
	String name;
	
	@Column(name="password")
	String password;
	
	@Column(name="email")
	String email;
	
	@Column(name="contact_no")
	String contactNo;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Role roleId;

	@Column(name="status")
	boolean status;

	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String name, String password, String email, String contactNo, Role roleId,
			boolean status) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.contactNo = contactNo;
		this.roleId = roleId;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
