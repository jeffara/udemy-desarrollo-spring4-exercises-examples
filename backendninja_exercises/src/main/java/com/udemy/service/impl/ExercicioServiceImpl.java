package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.ExercicioService;

@Service("exercicioService")
public class ExercicioServiceImpl<T> implements ExercicioService<T>  {

	private static Log LOGGER = null;
	
	@Override
	public void showLogMessage(T classe, String mensagem) {
		LOGGER = LogFactory.getLog(classe.getClass());
		
		LOGGER.info("Classe: " + classe.getClass().getName() + " - Mensagem: " + mensagem);
		
	}
}
