package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Movie;
import com.booking.Booking.services.duo.Movie_Duo;

@Service
public class Movie_Service implements Movie_Interface {

	@Autowired
	private Movie_Duo movie_Duo;
	
	@Override
	public List<Movie> getAll() {
		return movie_Duo.findAll();
	}

	@Override
	public Movie getById(long id) {
		return movie_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Movie obj) {
		try {
			movie_Duo.save(obj);
			return new ResponseEntity<>("Entry has been added", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> delete(long id) {
		try {
			Movie obj = movie_Duo.getById(id);
			movie_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Movie obj) {
		try {
			movie_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
