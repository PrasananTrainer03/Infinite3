package com.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LeaveDetailsDAO {

	Connection connection;
	PreparedStatement pst;
	
	public List<LeaveDetails> leaveHistory(int empId) throws ClassNotFoundException, SQLException {
		String cmd = "select * from leave_history where EMP_ID=?";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		List<LeaveDetails> leaveHistory = new ArrayList<LeaveDetails>();
		ResultSet rs = pst.executeQuery();
		LeaveDetails leaveDetails = null;
		while(rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveDetails.setEmpId(rs.getInt("EMP_ID"));
			leaveDetails.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveDetails.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveDetails.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveDetails.setLeaveReason(rs.getString("LEAVE_REASON"));
			leaveHistory.add(leaveDetails);
		}
		return leaveHistory;
	}
	
	
	public List<LeaveDetails> pendingLeave(int managerId) throws ClassNotFoundException, SQLException {
		String cmd = "select * from leave_history where LEAVE_STATUS='PENDING' AND EMP_ID IN "
				+ " (select emp_id from Employee where EMP_Manager_Id=?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, managerId);
		List<LeaveDetails> pendingLeaves = new ArrayList<LeaveDetails>();
		ResultSet rs = pst.executeQuery();
		LeaveDetails leaveDetails = null;
		while(rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveDetails.setEmpId(rs.getInt("EMP_ID"));
			leaveDetails.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveDetails.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveDetails.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveDetails.setLeaveReason(rs.getString("LEAVE_REASON"));
			pendingLeaves.add(leaveDetails);
		}
		return pendingLeaves;
	}
	
	public String approveDeny(int leaveId, int mgrId, String managerComments, String status) throws ClassNotFoundException, SQLException {
		LeaveDetails ld = searchByLeaveId(leaveId);
		connection = ConnectionHelper.getConnection();
		Employee emp = new EmployeeDAO().searchEmploy(ld.getEmpId());
		int empId = emp.getEmpId();
		int mgId = emp.getMgrId();
		int noOfDays = ld.getNoOfDays();
		if (mgrId==mgId) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update leave_history SET LEAVE_STATUS='APPROVED', "
						+ "LEAVE_MNGR_COMMENTS=? where LEAVE_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setString(1, managerComments);
				pst.setInt(2, leaveId);
				pst.executeUpdate();
				return "Your Leave Approved...";
			} else {
				String cmd = "Update leave_history SET LEAVE_STATUS='DENIED', "
						+ "LEAVE_MNGR_COMMENTS=? where LEAVE_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setString(1, managerComments);
				pst.setInt(2, leaveId);
				pst.executeUpdate();
				cmd = "UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BAL=EMP_AVAIL_LEAVE_BAL+? "
						+ " WHERE EMP_ID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, noOfDays);
				pst.setInt(2, empId);
				pst.executeUpdate();
				return "Your Leave not Approved...";
			}
		} else {
			return "You are an authorized Manager...";
		}
	}
	public LeaveDetails searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where LEAVE_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveId);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leaveDetails = null;
		if (rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveDetails.setEmpId(rs.getInt("EMP_ID"));
			leaveDetails.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveDetails.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveDetails.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveDetails.setLeaveReason(rs.getString("LEAVE_REASON"));
			
		}
		return leaveDetails;
	}
	
	public int weekDays(Date startDate, Date endDate) {
		List data = getDatesBetweenUsingJava7(startDate, endDate);
		List<String> dates = new ArrayList<String>();
		int weekDays = 0;
		String s="";
		for (Object object : data) {
		//	System.out.println(object);
			dates.add(object.toString());
		}
		System.out.println(dates.size());
		for (String str : dates) {
			if (str.contains("Sat") || str.contains("Sun")) {
				weekDays++;
		//	System.out.println(str);
			}
		}
	//	System.out.println("WeekDays are  " +weekDays);
		return weekDays;
	}
	
	public static List getDatesBetweenUsingJava7(Date startDate, Date endDate) {
		  List datesInRange = new ArrayList<>();
		  Calendar calendar = getCalendarWithoutTime(startDate);
		  Calendar endCalendar = getCalendarWithoutTime(endDate);

		  while (calendar.before(endCalendar)) {
		    Date result = calendar.getTime();
		    datesInRange.add(result);
		    calendar.add(Calendar.DATE, 1);
		  }

		  return datesInRange;
		}

		private static Calendar getCalendarWithoutTime(Date date) {
		  Calendar calendar = new GregorianCalendar();
		  calendar.setTime(date);
		  calendar.set(Calendar.HOUR, 0);
		  calendar.set(Calendar.HOUR_OF_DAY, 0);
		  calendar.set(Calendar.MINUTE, 0);
		  calendar.set(Calendar.SECOND, 0);
		  calendar.set(Calendar.MILLISECOND, 0);
		  return calendar;
		}
	public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
		/*
		 * 1. LeaveStartDate cannot be greater than leave End Date
		 * 2. Balance must be available
		 */
		 long ms = leaveDetails.getLeaveEndDate().getTime() - leaveDetails.getLeaveStartDate().getTime();
		    long m = ms / (1000 * 24 * 60 * 60);
		    int days = (int) m;
		    days = days + 1;
		    leaveDetails.setLeaveType(LeaveType.EL);
		    leaveDetails.setLeaveStatus(LeaveStatus.PENDING);
		 System.out.println("difference is  " +days);
		 EmployeeDAO edao = new EmployeeDAO();
		 Employee employee = edao.searchEmploy(leaveDetails.getEmpId());
		 if (employee!=null) {
			 int leaveAvail = employee.getLeaveAvail();
			 if (days < 0) {
				 return "Leave Start-Date Cannot be greater than Leave-End Date...";
			 } else if (leaveAvail-days < 0) {
				 return "Insufficient Leave Balance...";
			 } else {
				 	int diff = leaveAvail-days;
				 	int wkDays = weekDays(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
				 	System.out.println("Actual Leave  " +days);
				 	System.out.println("Week Days are  " +wkDays);
				 	System.out.println("Applied Leaves  " + (days-wkDays));
			    	leaveDetails.setNoOfDays(days-wkDays);
			    	connection = ConnectionHelper.getConnection();
			    	String cmd = "Insert into LEAVE_HISTORY(Emp_ID,Leave_Start_Date, "
			    			+ "Leave_End_Date,Leave_Type,Leave_Status,Leave_Reason,LEAVE_NO_OF_DAYS) "
			    			+ " VALUES(?,?,?,?,?,?,?)";
			    	pst = connection.prepareStatement(cmd);
			    	pst.setInt(1, leaveDetails.getEmpId());
			    	pst.setDate(2, leaveDetails.getLeaveStartDate());
			    	pst.setDate(3, leaveDetails.getLeaveEndDate());
			    	pst.setString(4, leaveDetails.getLeaveType().toString());
			    	pst.setString(5, leaveDetails.getLeaveStatus().toString());
			    	pst.setString(6, leaveDetails.getLeaveReason());
			    	pst.setInt(7, leaveDetails.getNoOfDays()); 
			    	pst.executeUpdate();
			    	cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL=? WHERE EMP_ID=?";
			    	pst = connection.prepareStatement(cmd);
			    	pst.setInt(1, diff);
			    	pst.setInt(2, leaveDetails.getEmpId());
			    	pst.executeUpdate();
			    	return "Leave Applied Successfully...";
			 }
		 } else {
			 return "Invalid Employee Id...";
		 }
	}
}
