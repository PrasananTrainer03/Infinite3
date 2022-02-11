<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.dxc.rs.Bookings"%>
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
<title>Book Room</title>
</head>
<body>
<%
	String roomId = request.getParameter("roomid");
%>
      <form method="get" action="BookRoom.jsp">
      <b>
		<center>
			Book Id : 
			<input type="text" name="bookid" /> <br/><br/> 
			Room Id : 
			<input type="text" name="roomid" value=<%=roomId %> /> <br/><br/> 
			Customer Name : 
			<input type="text" name="custname" /> <br/><br/> 
			City : 
			<input type="text" name="city" /> <br/><br/> 
			Booking Date :
			<input type="date" name="bookdate" /> <br/><br/>
			Check-In Date:
			<input type="date" name="chkdate" /> <br/><br/> 
			<input type="submit" value="Book Room" /> 
		</center>
	</b>
	</form> 
	<%
		if (request.getParameter("bookid") != null &&
				request.getParameter("roomid") != null &&
				request.getParameter("bookdate") != null &&
				request.getParameter("chkdate") != null 
			) {
			Bookings bookings = new Bookings();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bookings.setBookid(request.getParameter("bookid"));
			bookings.setRoomid(request.getParameter("roomid"));
			bookings.setCustname(request.getParameter("custname"));
			bookings.setCity(request.getParameter("city"));
			
			java.util.Date bkDate = sdf.parse(request.getParameter("bookdate"));
			java.util.Date chkDate = sdf.parse(request.getParameter("chkdate"));
			
			java.sql.Date d1 = new java.sql.Date(bkDate.getTime());
			java.sql.Date d2 = new java.sql.Date(chkDate.getTime());
			
			bookings.setBookdate(d1);
			bookings.setChkdate(d2);
			
			Client client = Client.create();

		     WebResource webResource = client
		        .resource("http://localhost:8181/bookRoom");

		  //   out.println(new Gson().toJson(employ));    
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		     String input = gson.toJson(bookings);
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