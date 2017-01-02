package com.udemy.service;

import java.util.List;

import com.udemy.model.CourseModel;

public interface CourseService {
	
	public List<CourseModel> listAllCourses();
	public CourseModel addCourse(CourseModel course);
	public int removeCourse(int idCourse);
	public CourseModel updateCourse(CourseModel course);
	public CourseModel findCourseById(int idCourse);

}
