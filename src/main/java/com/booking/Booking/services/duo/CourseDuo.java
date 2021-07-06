package com.booking.Booking.services.duo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.Booking.entities.Course;


public interface CourseDuo extends JpaRepository<Course, Long> {
	
}
