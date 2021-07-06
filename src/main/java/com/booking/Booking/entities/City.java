package com.booking.Booking.entities;

import java.util.*;

import javax.persistence.*;

public class City {
	
	// City Id
	@Id
	@Column(name = "CityId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CityId;
	
	// City Name
	@Column(name = "Name", length=64 , nullable = false)
	private String Name;

	// State Name
	@Column(name = "State", length=64 , nullable = false)
	private String State;
	
	// ZipCode
	@Column(name = "ZipCode", length=16 , nullable = false)		
	private String ZipCode;
	
	// One to Many Relationship (One city have multiple cinema)
	@OneToMany(mappedBy = "Cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cinema> Cinema;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(long cityId, String name, String state, String zipCode,
			List<com.booking.Booking.entities.Cinema> cinema) {
		super();
		CityId = cityId;
		Name = name;
		State = state;
		ZipCode = zipCode;
		Cinema = cinema;
	}

	public long getCityId() {
		return CityId;
	}

	public void setCityId(long cityId) {
		CityId = cityId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public List<Cinema> getCinema() {
		return Cinema;
	}

	public void setCinema(List<Cinema> cinema) {
		Cinema = cinema;
	}

	@Override
	public String toString() {
		return "City [CityId=" + CityId + ", Name=" + Name + ", State=" + State + ", ZipCode=" + ZipCode + ", Cinema="
				+ Cinema + "]";
	}

	//
	

}
