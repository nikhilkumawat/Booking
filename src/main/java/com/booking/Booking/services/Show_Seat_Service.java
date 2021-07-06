package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Show_Seat;
import com.booking.Booking.services.duo.Show_Seat_Duo;

@Service
public class Show_Seat_Service implements Show_Seat_Interface {

	@Autowired
	private Show_Seat_Duo show_Seat_Duo;
	
	@Override
	public List<Show_Seat> getAll() {
		return show_Seat_Duo.findAll();
	}

	@Override
	public Show_Seat getById(long id) {
		return show_Seat_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Show_Seat obj) {
		try {
			show_Seat_Duo.save(obj);
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
			Show_Seat obj = show_Seat_Duo.getById(id);
			show_Seat_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Show_Seat obj) {
		try {
			show_Seat_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
