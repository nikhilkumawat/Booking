package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Movie;

public interface Movie_Interface {

	public List<Movie> getAll();

	public Movie getById(long id);

	public ResponseEntity<String> add(Movie obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Movie obj);
	
}
