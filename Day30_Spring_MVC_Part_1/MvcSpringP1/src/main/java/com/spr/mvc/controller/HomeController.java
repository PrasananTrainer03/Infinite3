package com.spr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/omkar")
	public ModelAndView omkar() {
		return new ModelAndView("omkar");
	}
	
	@RequestMapping("/sarath")
	public ModelAndView sarath() {
		return new ModelAndView("sarath");
	}
	
	@RequestMapping("/suchita")
	public ModelAndView suchita() {
		return new ModelAndView("suchita");
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() throws IOException{
		return new ModelAndView("home");
	}
}
