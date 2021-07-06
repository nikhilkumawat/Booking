package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.booking.Booking.entities.Cinema;
import com.booking.Booking.services.duo.Cinema_Duo;

@Service
public class Cinema_Service implements Cinema_Interface {

	@Autowired
	private Cinema_Duo cinema_Duo;
	
	@Override
	public List<Cinema> getAll() {
		return cinema_Duo.findAll();
	}

	@Override
	public Cinema getById(long id) {
		return cinema_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Cinema obj) {
		try {
			cinema_Duo.save(obj);
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
			Cinema obj = cinema_Duo.getById(id);
			cinema_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Cinema obj) {
		try {
			cinema_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
