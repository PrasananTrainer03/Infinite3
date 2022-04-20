package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Person.xml");
		Person p1 = (Person)ctx.getBean("beanAtharva");
		Person p2 = (Person)ctx.getBean("beanAnushka");
		Person p3 = (Person)ctx.getBean("beanKamali");
		Person p4 = (Person)ctx.getBean("beanJegan");
		Person p5 = (Person)ctx.getBean("beanPavan");
		
		p1.showAllInfo();
		p2.showAllInfo();
		p3.showAllInfo();
		p4.showAllInfo();
		p5.showAllInfo();
	}
}
