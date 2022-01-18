package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Name.xml");
		Name name1 = (Name)ctx.getBean("beanKavya");
		System.out.println(name1.fullName());
		
		Name name2 = (Name)ctx.getBean("beanJaison");
		System.out.println(name2.fullName());
		
		Name name3 = (Name)ctx.getBean("beanMohammad");
		System.out.println(name3.fullName());
	}
}
