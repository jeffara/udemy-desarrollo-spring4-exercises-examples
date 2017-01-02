package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	private static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	//Exemplo com RequestMapping (Spring < 4.3)
	//Primeira Forma de Retorno de uma View (Template)
//	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
//	public String exampleString() {
//		return "example";
//	}
	
	//Exemplo com RequestMapping (Spring < 4.3)
	//Segunda Forma de Retorno de uma View (Template)
//	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
//	public ModelAndView exampleMAV() {
//		return new ModelAndView("example");
//	}
	
	//Exemplo com GetMapping (Spring >= 4.3)
	//Primeira Forma de Retorno de uma View (Template)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());

		return EXAMPLE_VIEW;
	}
	
	//Exemplo com GetMapping (Spring >= 4.3)
	//Segunda Forma de Retorno de uma View (Template)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		
		return mav;
	}
}
