package com.udemy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJPARepository;
import com.udemy.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJPARepository")
	private CourseJPARepository courseJPARepository;
	
	@Override
	public List<CourseModel> listAllCourses() {
		LOGGER.info("Call: listAllCourses()");
		return courseJPARepository.findAll()
								  .stream()
								  .map(ce -> CourseConverter.entityToModel(ce))
								  .collect(Collectors.toList());
	}

	@Override
	public CourseModel addCourse(CourseModel course) {
		LOGGER.info("Call: addCourse() -- Param: " + course);
		return CourseConverter.entityToModel(courseJPARepository.save(CourseConverter.modelToEntity(course)));
	}

	@Override
	public int removeCourse(int idCourse) {
		LOGGER.info("Call: removeCourse() -- Param: " + idCourse);
		courseJPARepository.delete(idCourse);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel course) {
		LOGGER.info("Call: updateCourse() -- Param: " + course);
		return CourseConverter.entityToModel(courseJPARepository.save(CourseConverter.modelToEntity(course)));
	}
	
	@Override
	public CourseModel findCourseById(int idCourse) {
		LOGGER.info("Call: findCourseById() -- Param: " + idCourse);
		return CourseConverter.entityToModel(courseJPARepository.findById(idCourse));
	}
}
