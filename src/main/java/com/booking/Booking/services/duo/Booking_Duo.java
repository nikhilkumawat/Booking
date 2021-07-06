package com.booking.Booking.services.duo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.Booking.entities.Booking;

public interface Booking_Duo extends JpaRepository<Booking, Long> {

}
