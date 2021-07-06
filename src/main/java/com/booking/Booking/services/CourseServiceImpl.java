package com.booking.Booking.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.Booking.entities.Course;
import com.booking.Booking.services.duo.CourseDuo;


@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	@Autowired
	private CourseDuo courseDuo;
	
	public CourseServiceImpl() {
		
//		list = new ArrayList<>();
//		list.add(new Course(142, "Java Core Course", "This course contains basic of java"));
//		list.add(new Course(140, "Spring Boot Course", "Creating the REST API"));
		
		
		
	}
	
	@Override
	public List<Course> getCourses(){
		
//		return list;
		
		return courseDuo.findAll();
		
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c = null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		
		return courseDuo.getOne(courseId);
		
	}
	
	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
//		return course;
		
		courseDuo.save(course);
		return course;
		
	}
	
	@Override
	public void deleteCourse(long courseId) {
		
//		boolean delete = false;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				list.remove(course);
//				delete = true;
//			}
//		}
//		return delete;
		
		Course entiry = courseDuo.getOne(courseId);
		courseDuo.delete(entiry);
		
	}
	
	public List<Course> updateCourse(Course c){
		
//		boolean found = false;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				found = true;
//				course.setTitle(c.getTitle().toString());
//				course.setDescription(c.getDescription().toString());
//				break;
//			}
//		}
//		if(!found) {
//			list.add(c);
//		}
//		return list;
		
		courseDuo.save(c);
		return courseDuo.findAll();
		
	}

	
}
