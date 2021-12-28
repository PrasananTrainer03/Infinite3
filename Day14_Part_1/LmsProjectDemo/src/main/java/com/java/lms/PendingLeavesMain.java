package com.java.lms;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PendingLeavesMain {

	public static void main(String[] args) {
		int managerId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Manager Id   ");
		managerId = sc.nextInt();
		try {
			List<LeaveDetails> pendingLeaves = new LeaveDetailsDAO().pendingLeave(managerId);
			for (LeaveDetails leaveDetails : pendingLeaves) {
				System.out.println(leaveDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
