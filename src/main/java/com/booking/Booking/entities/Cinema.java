package com.booking.Booking.entities;

import java.util.*;

import javax.persistence.*;

public class Cinema {

	// Cinema Id
	@Id
	@Column(name = "CinemaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CinemaId;
	
	// Cinema Name
	@Column(name = "Name", length=64 , nullable = false)
	private String Name;
	
	// Total Cinema Halls
	@Column(name = "TotalCinemaHalls")
	private Integer TotalCinemaHalls;
	
	// Many to One RelationShip (Many Cinema Halls in a city)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CityId", nullable = false)
    private City CityId;

	// One to Many Relation between Cinema and CinemaHall (One Cinema have multiple Cinema Halls)
	@OneToMany(mappedBy = "Cinema_Hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cinema_Hall> CinemaHall;


	// -----
	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cinema(long cinemaId, String name, Integer totalCinemaHalls, City cityId, List<Cinema_Hall> cinemaHall) {
		super();
		CinemaId = cinemaId;
		Name = name;
		TotalCinemaHalls = totalCinemaHalls;
		CityId = cityId;
		CinemaHall = cinemaHall;
	}


	public long getCinemaId() {
		return CinemaId;
	}


	public void setCinemaId(long cinemaId) {
		CinemaId = cinemaId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public Integer getTotalCinemaHalls() {
		return TotalCinemaHalls;
	}


	public void setTotalCinemaHalls(Integer totalCinemaHalls) {
		TotalCinemaHalls = totalCinemaHalls;
	}


	public City getCityId() {
		return CityId;
	}


	public void setCityId(City cityId) {
		CityId = cityId;
	}


	public List<Cinema_Hall> getCinemaHall() {
		return CinemaHall;
	}


	public void setCinemaHall(List<Cinema_Hall> cinemaHall) {
		CinemaHall = cinemaHall;
	}


	@Override
	public String toString() {
		return "Cinema [CinemaId=" + CinemaId + ", Name=" + Name + ", TotalCinemaHalls=" + TotalCinemaHalls
				+ ", CityId=" + CityId + ", CinemaHall=" + CinemaHall + "]";
	}


	
	
	
	
	
}
