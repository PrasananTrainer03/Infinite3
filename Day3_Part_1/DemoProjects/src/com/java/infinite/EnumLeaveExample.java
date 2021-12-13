package com.java.infinite;

public class EnumLeaveExample {

	public static void main(String[] args) {
		LeaveStatus leaveStatus = LeaveStatus.PENDING;
		
		String status="YeS";
		
		if (status.toUpperCase().equals("YES")) {
			leaveStatus = LeaveStatus.ACCEPTED;
		}
		if (status.toUpperCase().equals("NO")) {
			leaveStatus = LeaveStatus.REJECTD;
		}
		
		System.out.println(leaveStatus);
	}
}
