package com.booking.Booking.entities;

import javax.validation.constraints.*;

import java.util.*;

import javax.persistence.*;

import com.booking.Booking.enums.Booking_Status;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Booking {

	// Booking Id
	@Id
	@Column(name = "BookingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookingId;
	
	// Number of Seats can be book (min = 1 and max = 6)
	@Column(name = "NumberOfSeats")
	@Size(min = 1, max = 6)
	private Integer NumberOfSeats;
	
	// Booking Time 
	@Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date Timestamp;
	
	// Booking Status (Booked, Not_Booked)
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Booking_Status Status;
	
	// One to Many (In one booking multiple seats can be book)
	@OneToMany(mappedBy = "Show_Seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Show_Seat> Show_Seat;
	
	// Many to One (One user can do multiple booking)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserId", nullable = false)
    private User User;
	
	// One to one Relation between Booking and Payment Entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PaymentID")
	private Payment Payment;

	
	// -- 
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Booking(long bookingId, @Size(min = 1, max = 6) Integer numberOfSeats, Date timestamp, Booking_Status status,
			List<com.booking.Booking.entities.Show_Seat> show_Seat, com.booking.Booking.entities.User user,
			com.booking.Booking.entities.Payment payment) {
		super();
		BookingId = bookingId;
		NumberOfSeats = numberOfSeats;
		Timestamp = timestamp;
		Status = status;
		Show_Seat = show_Seat;
		User = user;
		Payment = payment;
	}


	public long getBookingId() {
		return BookingId;
	}


	public void setBookingId(long bookingId) {
		BookingId = bookingId;
	}


	public Integer getNumberOfSeats() {
		return NumberOfSeats;
	}


	public void setNumberOfSeats(Integer numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}


	public Date getTimestamp() {
		return Timestamp;
	}


	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}


	public Booking_Status getStatus() {
		return Status;
	}


	public void setStatus(Booking_Status status) {
		Status = status;
	}


	public List<Show_Seat> getShow_Seat() {
		return Show_Seat;
	}


	public void setShow_Seat(List<Show_Seat> show_Seat) {
		Show_Seat = show_Seat;
	}


	public User getUser() {
		return User;
	}


	public void setUser(User user) {
		User = user;
	}


	public Payment getPayment() {
		return Payment;
	}


	public void setPayment(Payment payment) {
		Payment = payment;
	}


	@Override
	public String toString() {
		return "Booking [BookingId=" + BookingId + ", NumberOfSeats=" + NumberOfSeats + ", Timestamp=" + Timestamp
				+ ", Status=" + Status + ", Show_Seat=" + Show_Seat + ", User=" + User + ", Payment=" + Payment + "]";
	}

	
	
	
}
