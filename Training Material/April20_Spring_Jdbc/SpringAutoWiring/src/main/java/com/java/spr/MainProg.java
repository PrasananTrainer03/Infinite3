package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Person.xml");
		Person person1 = (Person)ctx.getBean("beanAkshat");
		person1.showAllInfo();
	}
}
