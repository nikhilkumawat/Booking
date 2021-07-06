package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Payment;

public interface Payment_Interface {



	public List<Payment> getAll();

	public Payment getById(long id);

	public ResponseEntity<String> add(Payment obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Payment obj);
	
}
