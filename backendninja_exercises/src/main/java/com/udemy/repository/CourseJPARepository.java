package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.CourseEntity;

@Repository("courseJPARepository")
public interface CourseJPARepository extends JpaRepository<CourseEntity, Serializable> {
	
	
	public CourseEntity findById(int id);
}
