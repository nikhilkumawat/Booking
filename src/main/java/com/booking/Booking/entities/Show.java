package com.booking.Booking.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
public class Show {
	
	// Show Id
	@Id
	@Column(name = "ShowId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ShowId;
	
	// Show date
	@Column(name = "Date")
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date Date;
	
	// Show Start time
	@Column(name = "StartTime")
	@Temporal(TemporalType.TIME)
	private Date StartTime;
	
	// Show End time
	@Column(name = "EndTime")
	@Temporal(TemporalType.TIME)
	private Date EndTime;
	
	// One to one Relation between Show and Cinema Hall Entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CinemaHallID")
	private Cinema_Hall CinemaHall;
	
	// Many to One Relation between Shows to Movie (One movie have multiple shows)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MovieID", nullable = false)
    private Movie Movie;
	
	// One to Many Relation between Shows and Booking (One show have many bookings)
	@OneToMany(mappedBy = "Booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> Booking;

	// One to Many Relation between Shows and Show_Seat (One show have multiple seat)
	@OneToMany(mappedBy = "Show_Seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Show_Seat Show_Seat;

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(long showId, java.util.Date date, java.util.Date startTime, java.util.Date endTime,
			Cinema_Hall cinemaHall, com.booking.Booking.entities.Movie movie,
			List<com.booking.Booking.entities.Booking> booking, com.booking.Booking.entities.Show_Seat show_Seat) {
		super();
		ShowId = showId;
		Date = date;
		StartTime = startTime;
		EndTime = endTime;
		CinemaHall = cinemaHall;
		Movie = movie;
		Booking = booking;
		Show_Seat = show_Seat;
	}

	public long getShowId() {
		return ShowId;
	}

	public void setShowId(long showId) {
		ShowId = showId;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public Cinema_Hall getCinemaHall() {
		return CinemaHall;
	}

	public void setCinemaHall(Cinema_Hall cinemaHall) {
		CinemaHall = cinemaHall;
	}

	public Movie getMovie() {
		return Movie;
	}

	public void setMovie(Movie movie) {
		Movie = movie;
	}

	public List<Booking> getBooking() {
		return Booking;
	}

	public void setBooking(List<Booking> booking) {
		Booking = booking;
	}

	public Show_Seat getShow_Seat() {
		return Show_Seat;
	}

	public void setShow_Seat(Show_Seat show_Seat) {
		Show_Seat = show_Seat;
	}

	@Override
	public String toString() {
		return "Show [ShowId=" + ShowId + ", Date=" + Date + ", StartTime=" + StartTime + ", EndTime=" + EndTime
				+ ", CinemaHall=" + CinemaHall + ", Movie=" + Movie + ", Booking=" + Booking + ", Show_Seat="
				+ Show_Seat + "]";
	}

	
	//
	
	
		

}
