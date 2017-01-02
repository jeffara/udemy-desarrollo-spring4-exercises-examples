package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.repository.CourseJPARepository;

@Component("exampleComponent")
public class ExampleComponent {

	private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello() {
		LOGGER.info("Hello from ExampleComponent");
	}
}
