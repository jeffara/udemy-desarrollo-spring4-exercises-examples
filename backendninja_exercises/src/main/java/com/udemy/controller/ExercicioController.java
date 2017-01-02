package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.ExercicioService;

@Controller
@RequestMapping("/exercicio")
public class ExercicioController {

	@Autowired
	@Qualifier("exercicioService")
	private ExercicioService<ExercicioController> exercicioService;

	private long startTime;

	//Redirecionamento caso tenha acessado o path /exercicio apenas
	@GetMapping("/")
	public RedirectView redirectView() {
		return new RedirectView("/exercicio/metodo1");
	}

	//Redirecionamento para o metodo 2
	@GetMapping("/metodo1")
	public RedirectView method1() {
		startTime = System.currentTimeMillis();
		return new RedirectView("/exercicio/metodo2");
	}

	//Metodo 2 - Execucao do Log
	@GetMapping("/metodo2")
	public ModelAndView method2() {

		ModelAndView mav = new ModelAndView("mensagem");

		String mensagem = "--- TOTAL TIME: '" + (System.currentTimeMillis() - startTime) + "'ms";
		exercicioService.showLogMessage(this, mensagem);

		mav.addObject("mensagem", mensagem);

		return mav;
	}
}
