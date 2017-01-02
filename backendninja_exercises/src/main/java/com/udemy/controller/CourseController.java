package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.converter.CourseConverter;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSE_VIEW = "courses";
	private static final String LIST_ALL_COURSES_REDIRECT = "redirect:/courses/listallcourses";
	private static final String ADD_BUTTON = "ADD COURSE";
	private static final String UPDATE_BUTTON = "UPDATE COURSE";
	
	private static final Log LOGGER = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@GetMapping({"/listallcourses", "/"})
	public ModelAndView listAllCourses(@RequestParam(name="idcourse", defaultValue="0", required=true) int idCourse) {
		LOGGER.info("Call: " + "listAllCourses()");
		
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		
		//Utiliza a aplicacao de Stream do Java 8 para modificar os objetos de Entity para Model
		//Depois devolve a lista resultante, no formato CourseModel
		mav.addObject("courses", courseService.listAllCourses());
		
		if(idCourse != 0) {
			//LOGGER.info("Call: " + "updateCourse() -- Param: " + idCourse);
			mav.addObject("course", courseService.findCourseById(idCourse));
			mav.addObject("addRemoveButtonLabel", UPDATE_BUTTON);
		} else {
			//Cria um objeto vazio para que seja possivel inserir as informacoes nele pelo front-end do formulario courses.html
			mav.addObject("course", new CourseModel());
			mav.addObject("addRemoveButtonLabel", ADD_BUTTON);
		}
		
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel course) {
		LOGGER.info("Call: " + "addCourse() -- Param: " + course);
		
		courseService.addCourse(course);
		return LIST_ALL_COURSES_REDIRECT;
	}
	
	@GetMapping("/removecourse")
	public String deleteCourse(@RequestParam(name="idcourse", defaultValue="0", required=true) int idCourse) {
		LOGGER.info("Call: " + "removecourse() -- Param: " + idCourse);
		
		if(idCourse != 0) {
			courseService.removeCourse(idCourse);
		}
		
		return LIST_ALL_COURSES_REDIRECT;
	}
}
