package com.tap.model;

import java.util.Date;

public class User {

	private int user_id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone_number;
	private String address;
	private String role;
	private Date createdDate;
	private Date lastLoginDate;
	
	public User() {
		
	}

	public User(int user_id, String name, String username, String password, String email, String phone_number, String address,
			String role, Date createdDate, Date lastLoginDate) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPhone() {
		return phone_number;
	}

	public void setPhone(String phone) {
		this.phone_number = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	@Override
	public String toString() {
		return user_id+" "+ name+" "+ username+" "+ password+" "+ email+" "+ phone_number+" "+ address;
	}
	
}