package com.booking.Booking.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.booking.Booking.entities.Show_Seat;

public interface Show_Seat_Interface {

	public List<Show_Seat> getAll();

	public Show_Seat getById(long id);

	public ResponseEntity<String> add(Show_Seat obj);

	public ResponseEntity<String> delete(long id);

	public ResponseEntity<String> update(Show_Seat obj);
}
