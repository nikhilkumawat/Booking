package com.booking.Booking.services;

import java.util.List;

import com.booking.Booking.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public void deleteCourse(long courseId);

	public List<Course> updateCourse(Course course);

}
