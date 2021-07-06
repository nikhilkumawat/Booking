package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.booking.Booking.entities.Show;
import com.booking.Booking.services.duo.Show_Duo;

@Service
public class Show_Service implements Show_Interface{

	@Autowired
	private Show_Duo show_Duo;
	
	@Override
	public List<Show> getAll() {
		return show_Duo.findAll();
	}

	@Override
	public Show getById(long id) {
		return show_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Show obj) {
		try {
			show_Duo.save(obj);
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
			Show obj = show_Duo.getById(id);
			show_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Show obj) {
		try {
			show_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
