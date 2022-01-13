package com.java.rest;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employService")
public class EmployService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employ[] showEmploy() throws ClassNotFoundException, SQLException {
		return new EmployDAO().showEmploy();
	}
	
	@GET
	@Path("/{empno}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employ searchEmploy(@PathParam("empno") int empno) throws ClassNotFoundException, SQLException {
		return new EmployDAO().searchEmploy(empno);
	}
}
