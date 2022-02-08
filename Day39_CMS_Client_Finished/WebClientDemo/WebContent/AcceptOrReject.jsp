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
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="AcceptOrReject.jsp">
		<center>
			Order Id :
			<input type="number" name="orderId" /> <br/><br/> 
			Vendor Id : 
			<input type="number" name="vendorId" /> <br/><br/> 
			Status : 
			<select name="status">
				<option value="YES">Yes</option>
				<option value="NO">No</option>
			</select> <br/><br/> 
			<input type="submit" value="Accept or Reject" />
		</center>
	</form>
	<%
		if (request.getParameter("orderId") != null && request.getParameter("vendorId")!=null) {
			Client client = Client.create();
			int oid = Integer.parseInt(request.getParameter("orderId"));
			int vid = Integer.parseInt(request.getParameter("vendorId"));
			String status = request.getParameter("status");
		     WebResource webResource = client
		        .resource("http://localhost:8181/acceptOrRejectOrder/"+oid+"/"+vid+"/"+status);

		  //   out.println(new Gson().toJson(employ));    
		    // String input = new Gson().toJson(orders);
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