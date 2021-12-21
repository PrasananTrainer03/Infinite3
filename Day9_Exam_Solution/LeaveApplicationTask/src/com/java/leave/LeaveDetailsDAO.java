package com.java.leave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveDetailsDAO {

	static List<LeaveDetails> leaveDetailsList;
	
	static {
		leaveDetailsList = new ArrayList<LeaveDetails>();
	}
	
	public LeaveDetails searchLeaveDao(int leaveId) {
		LeaveDetails leaveFound = null;
		for (LeaveDetails leaveDetails : leaveDetailsList) {
			if (leaveDetails.getLeaveId()==leaveId) {
				leaveFound = leaveDetails;
			}
		}
		return leaveFound;
	}
	
	public List<LeaveDetails> showLeaveDao() {
		return leaveDetailsList;
	}
	
	public String addLeaveDao(LeaveDetails leaveDetails) {
		leaveDetails.setLeaveAppliedOn(new Date());
		long ms = leaveDetails.getLeaveEndDate().getTime() - 
						leaveDetails.getLeaveStartDate().getTime();
		
		long d = (ms /(1000*60*60*24));
		int days = (int)d;
		days++;
		leaveDetails.setNoOfDays(days);
		leaveDetailsList.add(leaveDetails);
		return "Leave Applied Successfully...";
	}
}
