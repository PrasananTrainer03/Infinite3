package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearchMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No    ");
		empno = sc.nextInt();
		EmployDAO dao = new EmployDAO();
		Employ employ = dao.searchEmploy(empno);
		if (employ!=null) {
			System.out.println(employ);
		} else {
			System.out.println("Record Not Found");
		}
	}
}
