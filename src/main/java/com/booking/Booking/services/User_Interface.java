package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.User;

public interface User_Interface {


	public List<User> getAll();

	public User getById(long id);

	public ResponseEntity<String> add(User obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(User obj);
	
	
}
