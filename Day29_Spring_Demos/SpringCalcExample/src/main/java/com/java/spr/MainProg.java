package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Calc.xml");
		Calc calc = (Calc)ctx.getBean("bean1");
		System.out.println("Sum is   " +calc.sum());
		System.out.println("Sub is  " +calc.sub());
		System.out.println("Mult is  " +calc.mult());
	}
}
