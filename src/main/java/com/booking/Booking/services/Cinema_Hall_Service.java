package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Cinema_Hall;
import com.booking.Booking.services.duo.Cinema_Hall_Duo;

@Service
public class Cinema_Hall_Service implements Cinema_Hall_Interface {

	@Autowired
	private Cinema_Hall_Duo cinema_Hall_Duo;
	
	@Override
	public List<Cinema_Hall> getAll() {
		// TODO Auto-generated method stub
		return cinema_Hall_Duo.findAll();
	}

	@Override
	public Cinema_Hall getById(long id) {
		// TODO Auto-generated method stub
		return cinema_Hall_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Cinema_Hall obj) {
		// TODO Auto-generated method stub
		try {
			cinema_Hall_Duo.save(obj);
			return new ResponseEntity<>("Entry has been added", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> delete(long id) {
		// TODO Auto-generated method stub
		try {
			Cinema_Hall obj = cinema_Hall_Duo.getById(id);
			cinema_Hall_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);

		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Cinema_Hall obj) {
		try {
			cinema_Hall_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
