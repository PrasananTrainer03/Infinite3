package com.java.comp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplainDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int tat(Date cdate) {
		
		java.util.Date today = new java.util.Date();
		
		java.sql.Date td = new java.sql.Date(today.getTime());
		long ms = td.getTime() - cdate.getTime();
	    long m = ms / (1000 * 24 * 60 * 60);
	    int days = (int) m;
	    days = days + 1;
		return days;
	}
	
	public Complaint searchComplaint(String cid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Complaint where ComplaintID=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, cid);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintId(rs.getString("ComplaintID"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setcDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("Severity"));
			complaint.setComplaintDate(rs.getDate("ComplaintDate"));
			complaint.setStatus(rs.getString("status"));
		}
		return complaint;
	}
	public Complaint[] showComplaint() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Complaint";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		List<Complaint> complaintList = new ArrayList<Complaint>();
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintId(rs.getString("ComplaintID"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setcDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("Severity"));
			complaint.setComplaintDate(rs.getDate("ComplaintDate"));
			complaint.setStatus(rs.getString("status"));
			complaintList.add(complaint);
		}
		return complaintList.toArray(new Complaint[complaintList.size()]);
	}
}
