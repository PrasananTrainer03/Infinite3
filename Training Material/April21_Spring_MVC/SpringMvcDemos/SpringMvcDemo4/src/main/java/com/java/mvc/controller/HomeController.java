package com.java.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		String user = req.getParameter("userName");
		String pwd = req.getParameter("passWord");
		if (user.equals("Surya") && pwd.contentEquals("Kumar")) {
			return new ModelAndView("home","result","Correct Credentials...");
		} else {
			return new ModelAndView("home","result","Invalid Credentials...");
		}
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
