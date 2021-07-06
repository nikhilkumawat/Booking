package com.booking.Booking.services.duo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.Booking.entities.Movie;

public interface Movie_Duo extends JpaRepository<Movie, Long> {

}
