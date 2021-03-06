package com.java.spr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping(value="/praharshini")
	public ModelAndView praharshini() {
		return new ModelAndView("home","message","Hi I am Sai Praharshini...");
	}
	
	@RequestMapping(value="/rahul")
	public ModelAndView rahul() {
		return new ModelAndView("home","message","Hi I am Rahul Garg...Spring MVC Topic");
	}
	@RequestMapping(value="/anushka")
	public ModelAndView anushka() {
		return new ModelAndView("home", "message", "Hi I am Anushka..Spring MVC Topic");
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
