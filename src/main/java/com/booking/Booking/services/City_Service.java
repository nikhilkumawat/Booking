package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.City;
import com.booking.Booking.services.duo.City_Duo;

@Service
public class City_Service implements City_Interface {


	@Autowired
	private City_Duo City_Duo;
	
	
	@Override
	public List<City> getAll() {
		return City_Duo.findAll();
	}

	@Override
	public City getById(long id) {
		return City_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(City obj) {
		try {
			City_Duo.save(obj);
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
			City obj = City_Duo.getById(id);
			City_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(City obj) {
		try {
			City_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
