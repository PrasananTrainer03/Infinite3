package com.java.infinite;

public class ApplyLeave {
	public static void main(String[] args) {
		LeaveType ltype = LeaveType.EL;
		String reason="PERSONAL";
//		if (reason.toUpperCase().equals("GENERAL")) {
//			ltype = LeaveType.EL;
//		}
		if (reason.toUpperCase().equals("PERSONAL")) {
			ltype = LeaveType.PL;
		}
		if (reason.toUpperCase().equals("PREGNANCY")) {
			ltype = LeaveType.ML;
		}
		System.out.println(ltype);
	}
}
