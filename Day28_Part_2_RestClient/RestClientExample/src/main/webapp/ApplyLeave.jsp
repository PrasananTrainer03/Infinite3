<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.rest.LeaveDetails"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.sun.jersey.api.client.ClientResponse"%>
<%@page import="com.sun.jersey.api.client.WebResource"%>
<%@page import="com.sun.jersey.api.client.Client"%>
<%@page import="javax.ws.rs.client.Invocation"%>
<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.core.Response"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="ApplyLeave.jsp">
		<center>
			Employee Id : 
			<input type="number" name="empno" /> <br/><br/> 
			Leave Start Date : 
			<input type="date" name="leaveStartDate" /> <br/><Br/> 
			Leave End Date  
			<input type="date" name="leaveEndDate" /> <br/><br/> 
			Leave Reason : 
			<input type="text" name="leaveReason" /> <br/><br/> 
			<input type="submit" value="Apply Leave" /> 
		</center>
	</form>
	<%
		if (request.getParameter("empno")!=null && 
			request.getParameter("leaveStartDate") !=null &&
			request.getParameter("leaveEndDate") !=null
				) {
			LeaveDetails leaveDetails = new LeaveDetails();
			leaveDetails.setEmpId(Integer.parseInt(request.getParameter("empno")));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date sd1 = sdf.parse(request.getParameter("leaveStartDate"));
			java.sql.Date sq1 = new java.sql.Date(sd1.getTime());
			java.util.Date sd2 = sdf.parse(request.getParameter("leaveEndDate"));
			java.sql.Date sq2 = new java.sql.Date(sd2.getTime());
			leaveDetails.setLeaveStartDate(sq1);
			leaveDetails.setLeaveEndDate(sq2);
			leaveDetails.setLeaveReason(request.getParameter("leaveReason"));
			Client client = Client.create();
			out.println(leaveDetails.getLeaveEndDate());

		     WebResource webResource = client
		        .resource("http://localhost:8080/LmsServiceExample/webapi/leave/applyLeave");
			//new Gson().toJson(employ);
		  //   out.println(new Gson().toJson(employ));    
		  // '{"empno":"18","name":"JOEL Varghese","gender":"MALE","dept":"Java","desig":"Programmer","basic":"48234"}' 
		  	Gson obj = new Gson();  
		  String input = obj.toJson(leaveDetails);
		  // String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
			out.println(input);
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