package com.java.lms;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public class EmployService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee[] showEmploy() throws ClassNotFoundException, SQLException {
		return new EmployeeDAO().showEmploy();
	}
	
	@GET
	@Path("/{empid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee searchEmploy(@PathParam("empid") int empid) throws ClassNotFoundException, SQLException {
		return new EmployeeDAO().searchEmploy(empid);
	}
}
