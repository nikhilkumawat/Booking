package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Show;

public interface Show_Interface {


	public List<Show> getAll();

	public Show getById(long id);

	public ResponseEntity<String> add(Show obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Show obj);
	
}
