<%@page import="com.java.rest.Employ"%>
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
	<table border="3" align="center">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
	
	
	<%
		URL url = new URL("http://localhost:8080/EmployServiceExample/webapi/employService");
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
 	     }
 	    ObjectMapper objectMapper = new ObjectMapper();
        Employ[] employArray = objectMapper.readValue(res, Employ[].class);
        for(Employ e : employArray) {
       %>
       	<tr>
       		<td><%=e.getEmpno() %> </td>
       		<td><%=e.getName() %> </td>
       		<td><%=e.getGender() %> </td>
       		<td><%=e.getDept() %> </td>
       		<td><%=e.getDesig() %> </td>
       		<td><%=e.getBasic() %> </td>
       		
       	</tr>
       <%
        }
	%>
	</table>
</body>
</html>