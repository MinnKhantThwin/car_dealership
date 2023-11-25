package com.hostmdy.model;

import java.time.LocalDate;

public class User {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private LocalDate date_of_birth;
	private String address;
	private String phone;
	private String role;
	private Boolean locked;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, LocalDate date_of_birth, String address, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.phone = phone;
	}

	public User(String name, String email, String password, LocalDate date_of_birth, String address, String phone,
			String role, Boolean locked) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.locked = locked;
	}

	public User(Long id, String name, String email, String password, LocalDate date_of_birth, String address,
			String phone, String role, Boolean locked) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.locked = locked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", date_of_birth="
				+ date_of_birth + ", address=" + address + ", phone=" + phone + ", role=" + role + ", locked=" + locked
				+ "]";
	}
	
}
