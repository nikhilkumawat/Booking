package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Cinema;

public interface Cinema_Interface {


	public List<Cinema> getAll();

	public Cinema getById(long id);

	public ResponseEntity<String> add(Cinema obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Cinema obj);
	
}
