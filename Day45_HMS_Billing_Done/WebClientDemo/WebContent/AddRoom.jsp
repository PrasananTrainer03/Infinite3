<%@page import="com.java.dxc.rs.Rooms"%>
<%@page import="com.sun.jersey.api.client.ClientResponse"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.sun.jersey.api.client.WebResource"%>
<%@page import="javax.ws.rs.client.Invocation"%>
<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="com.sun.jersey.api.client.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Room</title>
</head>
<body>
      <form method="get" action="AddRoom.jsp">
      <b>
		<center>
			Room Id : 
			<input type="search" name="roomid" /> <br/><br/> 
			Room Type : 
			<input type="text" name="type" /> <br/><br/>  
			Cost Per Day : 
			<input type="number" name="costperday" /> <br/><Br/> 
			<input type="submit" value="Add Room" /> 
		</center>
	</b>
	</form>
	<%
		if (request.getParameter("roomid") != null &&
				request.getParameter("type") != null &&
				request.getParameter("costperday") != null 
			) {
			Rooms rooms = new Rooms();
			rooms.setRoomid(request.getParameter("roomid"));
			rooms.setType(request.getParameter("type"));
			rooms.setStatus("Available");
			rooms.setCostperday(Integer.parseInt(request.getParameter("costperday")));
			
			Client client = Client.create();

		    WebResource webResource = client
		        .resource("http://localhost:8181/addRoom");

		  //   out.println(new Gson().toJson(employ));    
		     String input = new Gson().toJson(rooms);
		  // String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

		     ClientResponse res = webResource.type("application/json")
		        .post(ClientResponse.class, input);

		     if (response.getStatus() != 200) {
		         throw new RuntimeException("Failed : HTTP error code : "
		              + res.getStatus());
		     } 

		   //  out.println("Output from Server .... \n");
		     String output = res.getEntity(String.class);
		     out.println(output); 
		}
	%>
</body>
</html>