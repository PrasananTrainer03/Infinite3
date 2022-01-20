package com.spr.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
	
	@RequestMapping("/name")
	public ModelAndView show(HttpServletRequest req, HttpServletResponse res) {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String fullName = firstName + " " +lastName;
		return new ModelAndView("nameresult", "fullName", fullName);
	}
}
