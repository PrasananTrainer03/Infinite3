package com.java.lms;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LeaveHistoryMain {

	public static void main(String[] args) {
		int empId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id   ");
		empId = sc.nextInt();
		try {
			List<LeaveDetails> leavehistory = new LeaveDetailsDAO().leaveHistory(empId);
			for (LeaveDetails ld : leavehistory) {
				System.out.println(ld);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
