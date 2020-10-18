package com.springweb.hellocontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("WelcomeMessage","Hi Users!!!Welcome to G-Server. I am GURU AI Assitant.");
		
		return modelandview;
	}
	
}
