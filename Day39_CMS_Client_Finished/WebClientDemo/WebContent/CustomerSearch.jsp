<%@page import="com.java.dxc.rs.Customer"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="CustomerSearch.jsp">
		<center>
			Customer No : 
		<input type="number" name="custId" /> <br/><br/> 
		<input type="submit" value="Search" />
		</center>
	</form>
	<%
		if (request.getParameter("custId")!=null) {
			int a = Integer.parseInt(request.getParameter("custId"));
			 URL url = new URL("http://localhost:8181/customer/"+a);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");

		        if (conn.getResponseCode() != 200) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                    + conn.getResponseCode());
		        }

		        BufferedReader br = new BufferedReader(new InputStreamReader(
		            (conn.getInputStream())));

		        String output;
		        String res="";
		        while ((output = br.readLine()) != null) {
		        	res+=output;
		            //out.println(output);
		        }
		       // out.println(res);
		      Customer customer = new ObjectMapper().readValue(res, Customer.class);
		    out.println("Customer Id " + customer.getCusId()+ "<br/>");
		    out.println("Customer Name " +customer.getCusName() + "<br/>");
		    out.println("User Name  " +customer.getCusUsername() + "<br/>"); 
		    out.println("Password  " +customer.getCusPassword() + "<br/>");
		    out.println("Mobile  " +customer.getCusPhnNo() + "<br/>");
		}
	%>
</body>
</html>