package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsertMain {
	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number  ");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Employ Name   ");
		employ.setName(sc.next());
		System.out.println("Enter Gender  ");
		String gen = sc.next();
		if (gen.toUpperCase().equals("MALE")) {
			employ.setGender(Gender.MALE);
		}
		if (gen.toUpperCase().contentEquals("FEMALE")) {
			employ.setGender(Gender.FEMALE);
		}
		System.out.println("Enter Department    ");
		employ.setDept(sc.next());
		System.out.println("Enter Designation  ");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic   ");
		employ.setBasic(sc.nextDouble());
		EmployDAO dao = new EmployDAO();
		try {
			System.out.println(dao.addEmploy(employ));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
