package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearchMain {

	public static void main(String[] args) {
		EmployDAO dao = new EmployDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number   ");
		int empno = sc.nextInt();
		try {
			Employ employFound = dao.searchEmploy(empno);
			if (employFound!=null) {
				System.out.println(employFound);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
