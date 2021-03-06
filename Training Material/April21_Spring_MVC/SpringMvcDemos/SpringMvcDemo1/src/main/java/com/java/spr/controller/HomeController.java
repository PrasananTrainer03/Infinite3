package com.java.spr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/anmol")
	public ModelAndView anmol() {
		return new ModelAndView("anmol");
	}
	
	@RequestMapping(value="/kamali")
	public ModelAndView kamali() {
		return new ModelAndView("kamali");
	}
	
	@RequestMapping(value="/manasvi")
	public ModelAndView manasiv() {
		return new ModelAndView("manasvi");
	}
}
