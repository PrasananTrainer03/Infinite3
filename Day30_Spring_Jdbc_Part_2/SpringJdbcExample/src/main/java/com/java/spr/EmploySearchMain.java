package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmploySearchMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		EmployDAO dao = (EmployDAO)ctx.getBean("employDao");
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		Employ employ = dao.searchEmploy(empno);
		if (employ!=null) {
			System.out.println(employ);
		}
		else {
			System.out.println("*** Record Not Found ***");
		}
	}
}
