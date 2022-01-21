package com.java.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.mvc.dao.EmployDao;
import com.java.mvc.model.Employ;

@Controller
public class HomeController {

	@Autowired
	EmployDao dao;

	 @RequestMapping(value = "/newemploy", method = RequestMethod.GET)
	 public ModelAndView addemploy(ModelAndView model) {
		 Employ employ = new Employ();
		 model.addObject(employ); 
		 model.setViewName("employform");
		 return model;
	 }

	 @RequestMapping(value="/saveemploy", method = RequestMethod.POST)
	 public ModelAndView saveemploy(@ModelAttribute Employ employ) {
		 dao.addEmploy(employ);
		 return new ModelAndView("redirect:/");
	 }
	 
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
	
	 @RequestMapping(value="/editemploy")
		public ModelAndView editEmploy(HttpServletRequest request) {
		    int empno = Integer.parseInt(request.getParameter("empno"));
		    Employ employ = dao.searchEmploy(empno);
		    ModelAndView model = new ModelAndView("employsearchform");
		    model.addObject("employ", employ);
		 
		    return model;
		}

	@RequestMapping(value="/")
	public ModelAndView listEmploy(ModelAndView model) throws IOException{
		  List<Employ> listEmploy = dao.showEmploy();
		  model.addObject("listEmploy", listEmploy);
		  model.setViewName("home");
	     return model;
	}
}
