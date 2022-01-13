package com.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalcService {

	@GET
	@Path("/sum/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sum(@PathParam("a") int a, @PathParam("b") int b) {
		int c=a+b;
		String res="";
		res+=c;
		return res;
	}
	
	@GET
	@Path("/sub/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sub(@PathParam("a") int a, @PathParam("b") int b) {
		int c=a-b;
		String res="";
		res+=c;
		return res;
	}
	
	@GET
	@Path("/mult/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String mult(@PathParam("a") int a, @PathParam("b") int b) {
		int c=a*b;
		String res="";
		res+=c;
		return res;
	}
}
