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
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="PayBill.jsp">
		<center>
			Booking Id : 
			<input type="text" name="bookId" /> <br/><br/> 
			CheckOut Date : 
			<input type="date" name="checkoutDate" /> <br/><Br/> 
			<input type="submit" value="Pay Bill" />
		</center>
	</form>
	<%
		if (request.getParameter("bookId")!=null && request.getParameter("checkoutDate")!=null) {
			String bookId = request.getParameter("bookId");
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			String bid = request.getParameter("bookId");
			java.util.Date chkDate = sdf.parse(request.getParameter("checkoutDate"));
			
			java.sql.Date d1 = new java.sql.Date(chkDate.getTime());
			
			Client client = Client.create();

		     WebResource webResource = client
		        .resource("http://localhost:8181/billing/"+bookId + "/"+d1);

		  //   out.println(new Gson().toJson(employ));    
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		   //  String input = gson.toJson(bookings);
		  // String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

		     ClientResponse res = webResource.type("application/json")
		        .post(ClientResponse.class, null);

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