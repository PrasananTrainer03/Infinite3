<%@page import="com.java.dxc.rs.Rooms"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>

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
<title>Show Booked Rooms</title>
</head>
<body>
      <table border="3" style="background-color:Yellow";>
        <tr style="background-color:Pink">
	        <th>Room Id</th>
	        <th>Room Type</th>
	        <th>Room Status</th>
	        <th>Cost Per Day</th>
        </tr>
        <%
		    URL url = new URL("http://localhost:8181/roomsBooked");
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
	            // out.println(output);    
	        }
	        ObjectMapper objectMapper = new ObjectMapper();
	        Rooms[] rooms = objectMapper.readValue(res, Rooms[].class);
	        //  out.println(employ.length);

	        for(Rooms r : rooms) {
         %>
      	<tr>
  	    	<td> <%=r.getRoomid() %> </td>
  		    <td> <%=r.getType() %> </td>
  	     	<td> <%=r.getStatus() %> </td>
  	    	<td> <%=r.getCostperday() %> </td>
  	   </tr>
         <%
	        }
	       // out.println(res);
	     %>
	</table>
</body>
</html>