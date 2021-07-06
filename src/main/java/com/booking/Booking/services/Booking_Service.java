package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.booking.Booking.entities.Booking;
import com.booking.Booking.services.duo.Booking_Duo;

@Service
public class Booking_Service implements Booking_Interface {

	@Autowired
	private Booking_Duo booking_Duo;
	
	
	@Override
	public List<Booking> getAll() {
		
		return booking_Duo.findAll();
		
	}

	@Override
	public Booking getById(long id) {

		return booking_Duo.getById(id);

	}

	@Override
	public ResponseEntity<String> add(Booking obj) {
		try {
			booking_Duo.save(obj);
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
			Booking obj = booking_Duo.getById(id);
			booking_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);

		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> update(Booking obj) {
		try {
			booking_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
