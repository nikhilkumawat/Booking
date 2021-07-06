package com.booking.Booking.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.booking.Booking.enums.Seat_Status;

public class Show_Seat {

	@Id
	@Column(name = "ShowSeatID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ShowSeatID;
	
	// Seat Status (CLASSIC, PREMIUM)
	@Column(name = "SeatStatus")
	@Enumerated(EnumType.STRING)
	private Seat_Status SeatStatus;
	
	// Seat Price
	@Column(name = "Price")
	private BigDecimal Price;
	
	// Many to one relation between Booking and show_seats (A booking have multiple seats)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking Booking;

	// Many to One relation between Show and Show_seat (A show have multiple Seats)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ShowId", nullable = false)
    private Show Show;

	// Many to One relation between Cinema_seat and Show_seat (A cinema have multiple show_seats)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CinemaSeatId", nullable = false)
    private Cinema_Seat CinemaSeat;

	public Show_Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show_Seat(long showSeatID, Seat_Status seatStatus, BigDecimal price,
			com.booking.Booking.entities.Booking booking, com.booking.Booking.entities.Show show,
			Cinema_Seat cinemaSeat) {
		super();
		ShowSeatID = showSeatID;
		SeatStatus = seatStatus;
		Price = price;
		Booking = booking;
		Show = show;
		CinemaSeat = cinemaSeat;
	}

	public long getShowSeatID() {
		return ShowSeatID;
	}

	public void setShowSeatID(long showSeatID) {
		ShowSeatID = showSeatID;
	}

	public Seat_Status getSeatStatus() {
		return SeatStatus;
	}

	public void setSeatStatus(Seat_Status seatStatus) {
		SeatStatus = seatStatus;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public Booking getBooking() {
		return Booking;
	}

	public void setBooking(Booking booking) {
		Booking = booking;
	}

	public Show getShow() {
		return Show;
	}

	public void setShow(Show show) {
		Show = show;
	}

	public Cinema_Seat getCinemaSeat() {
		return CinemaSeat;
	}

	public void setCinemaSeat(Cinema_Seat cinemaSeat) {
		CinemaSeat = cinemaSeat;
	}

	@Override
	public String toString() {
		return "Show_Seat [ShowSeatID=" + ShowSeatID + ", SeatStatus=" + SeatStatus + ", Price=" + Price + ", Booking="
				+ Booking + ", Show=" + Show + ", CinemaSeat=" + CinemaSeat + "]";
	}

	
	//
	
	
	
	
}
