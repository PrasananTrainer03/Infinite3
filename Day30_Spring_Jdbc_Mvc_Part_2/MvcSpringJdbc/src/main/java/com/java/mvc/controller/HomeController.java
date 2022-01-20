package com.java.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.mvc.dao.EmployDaoImpl;
import com.java.mvc.model.Employ;

@Controller
public class HomeController {

	@Autowired
	EmployDaoImpl dao;
	
	@RequestMapping(value = "/deleteemploy", method = RequestMethod.GET)
	 public ModelAndView deleteEmploy(HttpServletRequest request) {
	     int empno = Integer.parseInt(request.getParameter("empno"));
	     dao.deleteEmploy(empno);
	     return new ModelAndView("redirect:/");
	 }
	
	@RequestMapping(value = "/updateemploy", method = RequestMethod.POST)
	 public ModelAndView updateemploy(@ModelAttribute Employ employ) {
		 dao.updateEmploy(employ);
	     return new ModelAndView("redirect:/");
	 }
	
	
	@RequestMapping("/editemploy")
	public ModelAndView searchEmploy(HttpServletRequest req) {
		  int empno = Integer.parseInt(req.getParameter("empno"));
		    Employ employ = dao.searchEmploy(empno);
		    ModelAndView model = new ModelAndView("employsearchform");
		    model.addObject("employ", employ);
		 
		    return model;
	}
	
	@RequestMapping(value="/")
	public ModelAndView showEmploy() {
		List<Employ> employList = dao.showEmploy();
		return new ModelAndView("home", "employList", employList);
	}
}
