package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Cinema_Seat;

public interface Cinema_Seat_Interface {

	public List<Cinema_Seat> getAll();

	public Cinema_Seat getById(long id);

	public ResponseEntity<String> add(Cinema_Seat obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Cinema_Seat obj);
}
