package com.booking.Booking.entities;

import java.util.Set;

import javax.persistence.*;

public class Cinema_Hall {

	// Cinema Id
	@Id
	@Column(name = "CinemaHallID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CinemaHallID;
	
	// Cinema Hall Name
	@Column(name = "Name", length=64 , nullable = false)
	private String Name;
	
	// Total Seats in a Cinema hall
	@Column(name = "TotalSeats")
	private Integer TotalSeats;
	
	// One to Many relation between Cinema hall and cinema seat 
	@OneToMany(mappedBy = "Cinema_Seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cinema_Seat> CinemaSeat;
	
	// Many to One relation between Cinema and Cinema halls (One Cinema have multiple cinema halls)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CinemaId", nullable = false)
    private Cinema Cinema;
    
	// One to one relation between Show and Cinema halls (one show in a cinema halls)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ShowId")
	private Show ShowId;

	// --------
    public Cinema_Hall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cinema_Hall(long cinemaHallID, String name, Integer totalSeats, Set<Cinema_Seat> cinemaSeat,
			com.booking.Booking.entities.Cinema cinema, Show showId) {
		super();
		CinemaHallID = cinemaHallID;
		Name = name;
		TotalSeats = totalSeats;
		CinemaSeat = cinemaSeat;
		Cinema = cinema;
		ShowId = showId;
	}

	public long getCinemaHallID() {
		return CinemaHallID;
	}

	public void setCinemaHallID(long cinemaHallID) {
		CinemaHallID = cinemaHallID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getTotalSeats() {
		return TotalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		TotalSeats = totalSeats;
	}

	public Set<Cinema_Seat> getCinemaSeat() {
		return CinemaSeat;
	}

	public void setCinemaSeat(Set<Cinema_Seat> cinemaSeat) {
		CinemaSeat = cinemaSeat;
	}

	public Cinema getCinema() {
		return Cinema;
	}

	public void setCinema(Cinema cinema) {
		Cinema = cinema;
	}

	public Show getShowId() {
		return ShowId;
	}

	public void setShowId(Show showId) {
		ShowId = showId;
	}

	@Override
	public String toString() {
		return "Cinema_Hall [CinemaHallID=" + CinemaHallID + ", Name=" + Name + ", TotalSeats=" + TotalSeats
				+ ", CinemaSeat=" + CinemaSeat + ", Cinema=" + Cinema + ", ShowId=" + ShowId + "]";
	}
	
	
    
    
}
