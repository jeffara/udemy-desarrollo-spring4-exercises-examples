package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.CourseEntity;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	//Transforma de uma Entity para um Model
	public static CourseModel entityToModel(CourseEntity courseEntity) {
		return new CourseModel(courseEntity.getId(), courseEntity.getName(), courseEntity.getDescription(), courseEntity.getPrice(), courseEntity.getHours());
	}
	
	//Transforma de um Model para uma Entity
	public static CourseEntity modelToEntity(CourseModel courseModel) {
		return new CourseEntity(courseModel.getId(), courseModel.getName(), courseModel.getDescription(), courseModel.getPrice(), courseModel.getHours());
	}
}
