<%@page import="com.java.dxc.rs.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3">
<tr>
	<th>Employ No</th>
	<th>Employ Name</th>
	<th>Department</th>
	<th>Designation</th>
	<th>Salary</th>
</tr>

<%
		 URL url = new URL("http://localhost:8181/showCustomer");
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
	          //  out.println(output);
	            
	        }
	        ObjectMapper objectMapper = new ObjectMapper();
	        Customer[] customer = objectMapper.readValue(res, Customer[].class);
	      //  out.println(employ.length);

	        for(Customer c : customer) {
  %>
  	<tr>
  		<td> <%=c.getCusId() %> </td>
  		<td> <%=c.getCusName() %> </td>
  		<td> <%=c.getCusPassword() %> </td>
  		<td> <%=c.getCusUsername() %> </td>
  		<td><%=c.getCusPhnNo() %> </td>
  	</tr>
  <%
	       	
	        }
	     // out.println(res);
	  %>
	  </table>
</body>
</html>