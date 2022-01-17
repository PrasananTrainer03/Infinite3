package com.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/name")
public class NameService {

	@GET
	@Path("/info/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String greet(@PathParam("name") String name) {
		return "Good Morning..."+name;
	}
	
	@GET
	@Path("/show/{firstName}/{lastName}")
	@Produces(MediaType.TEXT_PLAIN) 
	public String show(@PathParam("firstName") String firstName, 
			@PathParam("lastName") String lastName
			) {
		String fullName = firstName + " " +lastName;
		return fullName;
	}
	
}
