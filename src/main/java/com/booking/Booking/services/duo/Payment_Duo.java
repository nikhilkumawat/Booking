package com.booking.Booking.services.duo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.Booking.entities.Payment;

public interface Payment_Duo extends JpaRepository<Payment, Long> {

}
