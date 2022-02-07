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
<%@page import="com.java.dxc.rs.Orders"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="PlaceOrder.jsp">
		<center>
			Customer Id : 
			<input type="number" name="customerId" /> <br/><br/> 
			Menu Id : 
			<input type="number" name="menuId" /> <br/><br/> 
			Vendor Id : 
			<input type="number" name="vendorId" /> <br/><br/> 
			Order Quantity : 
			<input type="number" name="qty" /> <br/><Br/> 
			Paymode : 
			<select name="payMode">
				<option value="PAYTM">Paytm</option> 
				<option value="DEBIT_CARD">Debit Card</option> 
				<option value="CREDIT_CARD">Credit Card</option> 
			</select> <br/><br/> 
			Order Comments : 
			<input type="text" name="orderComments" /> <br/><br/> 
			<input type="submit" value="Place Order" /> 
		</center>
	</form>
	<%
		if (request.getParameter("customerId") != null &&
				request.getParameter("menuId") != null &&
				request.getParameter("vendorId") != null &&
				request.getParameter("qty") != null 
			) {
			Orders orders = new Orders();
			orders.setCusId(Integer.parseInt(request.getParameter("customerId")));
			orders.setMenId(Integer.parseInt(request.getParameter("menuId")));
			orders.setVenId(Integer.parseInt(request.getParameter("vendorId")));
			orders.setOrdQuantity(Integer.parseInt(request.getParameter("qty")));
			orders.setWalSource(request.getParameter("payMode"));
			orders.setOrdComments(request.getParameter("orderComments"));
			
			Client client = Client.create();

		     WebResource webResource = client
		        .resource("http://localhost:8181/placeOrder");

		  //   out.println(new Gson().toJson(employ));    
		     String input = new Gson().toJson(orders);
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