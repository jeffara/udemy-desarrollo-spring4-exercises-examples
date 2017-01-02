package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.PersonModel;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	//Primeira forma de redirecionamento
	/*@GetMapping("/")
	public String redirectString() {
		return "redirect:/example3/showform";
	}*/
	
	//Segunda forma de redirecionamento
	@GetMapping("/")
	public RedirectView redirectView() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("Visualização de Formulário Acessada");
		model.addAttribute("person", new PersonModel());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") PersonModel person, BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView();
		
		LOGGER.info("METHOD: 'addPerson' Acessado. PARAMS: '" + person + "'" );
		
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		} else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		
		System.out.println("PERSON = " + person);
		
		return mav;
	}
}
