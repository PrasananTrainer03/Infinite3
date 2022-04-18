package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployDeleteMain {

	public static void main(String[] args) {
		EmployDAO dao = new EmployDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number   ");
		int empno=sc.nextInt();
		try {
			System.out.println(dao.deleteEmploy(empno));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
