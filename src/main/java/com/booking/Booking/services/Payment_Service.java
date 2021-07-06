package com.booking.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Payment;
import com.booking.Booking.services.duo.Payment_Duo;

@Service
public class Payment_Service implements Payment_Interface {

	@Autowired
	private Payment_Duo payment_Duo;
	
	@Override
	public List<Payment> getAll() {
		return payment_Duo.findAll();
	}

	@Override
	public Payment getById(long id) {
		return payment_Duo.getById(id);
	}

	@Override
	public ResponseEntity<String> add(Payment obj) {
		try {
			payment_Duo.save(obj);
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
			Payment obj = payment_Duo.getById(id);
			payment_Duo.delete(obj);
			return new ResponseEntity<>("Entry has been deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> update(Payment obj) {
		try {
			payment_Duo.save(obj);
			return new ResponseEntity<>("Entry has been updated", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Exception: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
