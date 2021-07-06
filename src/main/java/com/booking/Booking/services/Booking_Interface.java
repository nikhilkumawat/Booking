package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Booking;

public interface Booking_Interface {


	public List<Booking> getAll();

	public Booking getById(long id);

	public ResponseEntity<String> add(Booking obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Booking obj);
	
}
