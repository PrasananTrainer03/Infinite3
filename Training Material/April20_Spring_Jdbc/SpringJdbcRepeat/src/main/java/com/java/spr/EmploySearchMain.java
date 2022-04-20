package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmploySearchMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno;
		System.out.println("Enter Employ No  ");
		empno=sc.nextInt();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		EmployDAO dao = (EmployDAO)ctx.getBean("myDao");
		Employ employ = dao.searchEmploy(empno);
		if (employ!=null) {
			System.out.println(employ);
		} else {
			System.out.println("Not Found...");
		}
	}
}
