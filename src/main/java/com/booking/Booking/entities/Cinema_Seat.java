package com.booking.Booking.entities;

import java.util.*;

import javax.persistence.*;

import com.booking.Booking.enums.Seat_Type;

public class Cinema_Seat {

	// Cinema Seat ID
	@Id
	@Column(name = "CinemaSeatId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CinemaSeatId;
	
	// Seat Number
	@Column(name = "SeatNumber")
	private Integer SeatNumber;
	
	// Seat Type (CLASSIC, PREMIUM)
	@Column(name = "SeatType")
	@Enumerated(EnumType.STRING)
	private Seat_Type SeatType;
	
	// Many to One Relationship (Multiple Cinema Seat in a cinema hall)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CinemaHallID", nullable = false)
    private Cinema_Hall CinemaHallID;
	
	// One to Many relationship (Multiple Seat Booked in cinema Seat)
	@OneToMany(mappedBy = "Show_Seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Show_Seat> Show_Seat;

	
	//------------
	public Cinema_Seat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cinema_Seat(long cinemaSeatId, Integer seatNumber, Seat_Type seatType, Cinema_Hall cinemaHallID,
			List<com.booking.Booking.entities.Show_Seat> show_Seat) {
		super();
		CinemaSeatId = cinemaSeatId;
		SeatNumber = seatNumber;
		SeatType = seatType;
		CinemaHallID = cinemaHallID;
		Show_Seat = show_Seat;
	}


	public long getCinemaSeatId() {
		return CinemaSeatId;
	}


	public void setCinemaSeatId(long cinemaSeatId) {
		CinemaSeatId = cinemaSeatId;
	}


	public Integer getSeatNumber() {
		return SeatNumber;
	}


	public void setSeatNumber(Integer seatNumber) {
		SeatNumber = seatNumber;
	}


	public Seat_Type getSeatType() {
		return SeatType;
	}


	public void setSeatType(Seat_Type seatType) {
		SeatType = seatType;
	}


	public Cinema_Hall getCinemaHallID() {
		return CinemaHallID;
	}


	public void setCinemaHallID(Cinema_Hall cinemaHallID) {
		CinemaHallID = cinemaHallID;
	}


	public List<Show_Seat> getShow_Seat() {
		return Show_Seat;
	}


	public void setShow_Seat(List<Show_Seat> show_Seat) {
		Show_Seat = show_Seat;
	}


	@Override
	public String toString() {
		return "Cinema_Seat [CinemaSeatId=" + CinemaSeatId + ", SeatNumber=" + SeatNumber + ", SeatType=" + SeatType
				+ ", CinemaHallID=" + CinemaHallID + ", Show_Seat=" + Show_Seat + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
