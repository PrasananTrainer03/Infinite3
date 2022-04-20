package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Company.xml");
		Company company = (Company)ctx.getBean("beanJegan");
		System.out.println(company.showCompany("Jegan"));
		System.out.println(company.showBranch("Jegan"));
		
		Company company2 = (Company)ctx.getBean("beanManasvi");
		System.out.println(company2.showCompany("Manasvi"));
		System.out.println(company2.showBranch("Manasvi"));
		
		Company company3 = (Company)ctx.getBean("beanSurya");
		System.out.println(company3.showCompany("Surya"));
		System.out.println(company3.showBranch("Surya"));
	}
}
