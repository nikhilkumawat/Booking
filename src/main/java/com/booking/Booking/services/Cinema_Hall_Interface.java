package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Cinema_Hall;

public interface Cinema_Hall_Interface {


	public List<Cinema_Hall> getAll();

	public Cinema_Hall getById(long id);

	public ResponseEntity<String> add(Cinema_Hall obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Cinema_Hall obj);
	
}
