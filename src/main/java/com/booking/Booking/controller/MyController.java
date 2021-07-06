package com.booking.Booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.booking.Booking.entities.Movie;
import com.booking.Booking.services.Movie_Service;

@RestController
public class MyController {
 
	@Autowired
	private Movie_Service movie_Service;
	
	// Get all the Movies
	@GetMapping("/movie")
	public List<Movie> getAll(){
		return this.movie_Service.getAll();
	}
	
	// Get Movie by ID
	@GetMapping("/movie/{ID}")
	public Movie getById(@PathVariable String ID) {
		
		return this.movie_Service.getById(Long.parseLong(ID));
		
	}
	
	// Add new Movie
	@PostMapping("/movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		try {
			this.movie_Service.add(movie);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Update old Movie
	@PutMapping("/movie")
	public ResponseEntity<String> updateCourse(@RequestBody Movie movie) {		
		try {
			this.movie_Service.update(movie);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete Movie by ID
	@DeleteMapping("/movie/{ID}")
	public ResponseEntity<String> deleteCourse(@PathVariable String ID) {
		try {
			this.movie_Service.delete(Long.parseLong(ID));
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Exception: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
