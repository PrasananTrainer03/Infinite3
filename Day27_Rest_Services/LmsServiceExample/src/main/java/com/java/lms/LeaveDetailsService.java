package com.java.lms;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/leave")
public class LeaveDetailsService {

	@GET
	@Path("/{leaveId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails searchByLeaveId(@PathParam("leaveId") int leaveId) throws ClassNotFoundException, SQLException {
		return new LeaveDetailsDAO().searchByLeaveId(leaveId);
	}
	
	@GET
	@Path("/history/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails[] leaveHistory(@PathParam("empId") int empId) throws ClassNotFoundException, SQLException {
		return new LeaveDetailsDAO().leaveHistory(empId);
	}
	
	@GET
	@Path("/pending/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails[] pending(@PathParam("empId") int empId) throws ClassNotFoundException, SQLException {
		return new LeaveDetailsDAO().pendingLeaves(empId);
	}
}
