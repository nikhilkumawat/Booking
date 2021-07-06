package com.booking.Booking.entities;

import java.util.*;

import javax.persistence.*;

public class User {

	// User Id
	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	
	// User Name
	@Column(name = "Name", length=64 , nullable = false)
	private String Name;

	// User Password
	@Column(name = "Password", length=20 , nullable = false)
	private String Password;
	
	// User Email
	@Column(name = "Email", length=64 , nullable = false)
	private String Email;
	
	// User Phone
	@Column(name = "Phone", length=16 , nullable = false)
	private String Phone;
	
	// One to Many Relation (one user multiple booking)
	@OneToMany(mappedBy = "Booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> Booking;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String name, String password, String email, String phone,
			List<com.booking.Booking.entities.Booking> booking) {
		super();
		UserId = userId;
		Name = name;
		Password = password;
		Email = email;
		Phone = phone;
		Booking = booking;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public List<Booking> getBooking() {
		return Booking;
	}

	public void setBooking(List<Booking> booking) {
		Booking = booking;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Name=" + Name + ", Password=" + Password + ", Email=" + Email + ", Phone="
				+ Phone + ", Booking=" + Booking + "]";
	}
	
	// 
	
	

	
}
