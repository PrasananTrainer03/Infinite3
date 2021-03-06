package com.java.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping(value="/calc")
	public ModelAndView calc(HttpServletRequest req, HttpServletResponse res) {
		int firstNo = Integer.parseInt(req.getParameter("firstNo"));
		int secondNo = Integer.parseInt(req.getParameter("secondNo"));
		int c = firstNo + secondNo;
		String result="Sum is  ";
		result+=c;
		return new ModelAndView("home", "result", result);
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
