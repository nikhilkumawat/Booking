package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.City;

public interface City_Interface {


	public List<City> getAll();

	public City getById(long id);

	public ResponseEntity<String> add(City obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(City obj);
}
