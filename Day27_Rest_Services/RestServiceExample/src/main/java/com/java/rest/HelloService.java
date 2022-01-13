package com.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Welcome to Restfull Webservice...";
	}
	
	@GET
	@Path("/omkar")
	@Produces(MediaType.TEXT_PLAIN)
	public String omkar() {
		return "Hi I am Omkar Bhagat...";
	}
	
	@GET
	@Path("/sunil")
	@Produces(MediaType.TEXT_PLAIN)
	public String sunil() {
		return "Hi I am Sunil...";
	}
}
