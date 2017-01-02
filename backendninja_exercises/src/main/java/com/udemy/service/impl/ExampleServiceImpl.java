package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.PersonModel;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<PersonModel> getListPeople() {
		List<PersonModel> people = new ArrayList<>();
		
		people.add(new PersonModel("Jefferson", 29));
		people.add(new PersonModel("Araujo", 30));
		people.add(new PersonModel("Rodrigo", 43));
		people.add(new PersonModel("Alberto", 18));
		people.add(new PersonModel("Fernando", 33));
		
		LOGGER.info("Service getListPeople Accessed!");
		
		return people;
	}
}
