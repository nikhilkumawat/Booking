package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Cinema_Seat;
import com.booking.Booking.services.duo.Cinema_Seat_Duo;

@Service
public class Cinema_Seat_Service implements Cinema_Seat_Interface {

	@Autowired
	private Cinema_Seat_Duo cinema_Seat_Duo;
	
	
	@Override
	public List<Cinema_Seat> getAll() {
		return cinema_Seat_Duo.findAll();
	}

	@Override
	public Cinema_Seat getById(long id) {
		return cinema_Seat_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Cinema_Seat obj) {
		try {
			cinema_Seat_Duo.save(obj);
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
			Cinema_Seat obj = cinema_Seat_Duo.getById(id);
			cinema_Seat_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Cinema_Seat obj) {
		try {
			cinema_Seat_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
