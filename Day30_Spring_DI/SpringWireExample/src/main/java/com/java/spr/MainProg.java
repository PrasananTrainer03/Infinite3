package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/person.xml");
		Person p1 = (Person)ctx.getBean("beanDinesh");
		p1.showAllInfo();
		
		Person p2 = (Person)ctx.getBean("beanShahida");
		p2.showAllInfo();
		
		Person p3 = (Person)ctx.getBean("beanJaison");
		p3.showAllInfo();
	}
}
