package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Person.xml");
		Person p1 = (Person)ctx.getBean("beanAtharva");
		Person p2 = (Person)ctx.getBean("beanAnushka");
		Person p3 = (Person)ctx.getBean("beanKamali");
		
		p1.showAllInfo();
		p2.showAllInfo();
		p3.showAllInfo();
	}
}
