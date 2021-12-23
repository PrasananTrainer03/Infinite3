package com.java.jdbc;

import java.sql.SQLException;
import java.util.List;

public class EmployMain {

	public static void main(String[] args) {
		EmployDAO dao = new EmployDAO();
		try {
			List<Employ> arrEmploy = dao.showEmploy();
			for (Employ employ : arrEmploy) {
				System.out.println(employ);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
