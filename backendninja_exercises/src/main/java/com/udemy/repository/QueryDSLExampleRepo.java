package com.udemy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.CourseEntity;
import com.udemy.entity.QCourseEntity;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourseEntity qCourseEntity = QCourseEntity.courseEntity;
	
	@PersistenceContext
	private EntityManager em;
	
	public CourseEntity find(boolean exists) {
		
		JPAQuery<CourseEntity> queryCourseEntity = new JPAQuery<>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourseEntity.description.endsWith("OP"));
		
		if(exists) {
			Predicate predicate2 = qCourseEntity.id.eq(3);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourseEntity.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		return queryCourseEntity.select(qCourseEntity).from(qCourseEntity).where(predicateBuilder).fetchOne();
		
	}
}
