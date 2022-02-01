package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/empall") 
	public Employ[] showEmploy() {
		Employ[] arrEmp = new Employ[] {
			new Employ(1, "Aryan", 88234),
			new Employ(3, "Gowri",882355),
			new Employ(4, "Naresh",88123)
		};
		return arrEmp;
	}
	
	@RequestMapping("/sum/{a}/{b}")
	public String sum(@PathVariable int a, @PathVariable int b) {
		int c=a+b;
		String res="";
		res+=c;
		return res;
	}
	
	@RequestMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Good Morning " +name;
	}
	
	@RequestMapping("/")
	public String sayHello() {
		return "Welcome to SpringBoot...";
	}
	
	@RequestMapping("/omkar") 
	public String omkar()
	{
		return "Hi I am Omkar....";
	}
}
