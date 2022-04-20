package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployDeleteMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		EmployDAO dao = (EmployDAO)ctx.getBean("myDao");
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		System.out.println(dao.deleteEmploy(empno));
	}
}
