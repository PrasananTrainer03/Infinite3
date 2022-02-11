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
<title>Search Room</title>
</head>
<body>
     <form method="get" action="SearchRoom.jsp">
     <b>
		<center>
		Room No : 
		<input type="search" name="roomid" /> <br/><br/> 
		<input type="submit" value="Search Room" />
		</center>
	 </b>
	 </form>
	 <%
		 if (request.getParameter("roomid")!=null) {
			    String a = request.getParameter("roomid");
			    URL url = new URL("http://localhost:8181/rooms/"+a);
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
		        Rooms rooms = new ObjectMapper().readValue(res, Rooms.class);
		        out.println("<b>Room No :</b>" + rooms.getRoomid() + "<br/>");
		        out.println("<b>Room Type :</b>" + rooms.getType() + "<br/>");
		        out.println("<b>Room Status :</b>" + rooms.getStatus() + "<br/>");
		        out.println("<b>Cost Per Day :</b>" + rooms.getCostperday() + "<br/>");
		    }
	   %>
</body>
</html>