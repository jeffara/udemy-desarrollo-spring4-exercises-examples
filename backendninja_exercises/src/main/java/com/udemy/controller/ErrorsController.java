package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
	
	private static final String INTERNAL_SERVER_ERROR_VIEW = "error/505";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return INTERNAL_SERVER_ERROR_VIEW;
	}

}
