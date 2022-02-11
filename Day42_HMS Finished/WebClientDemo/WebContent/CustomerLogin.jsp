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
	<form method="post" action="CustomerLogin.jsp">
		<center>
			User Name : 
			<input type="text" name="userName" /> <br/><br/> 
			Password : 
			<input type="password" name="passWord" /> <br/><br/> 
			<input type="submit" value="Login" />
		</center>
	</form>
	<%
		if (request.getParameter("userName")!=null && 
			request.getParameter("passWord") !=null
				) {
			
				String user= request.getParameter("userName");
				String pwd = request.getParameter("passWord");
				 URL url = new URL("http://localhost:8181/custAuthenticate/"+user+"/"+pwd);
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
			       out.println(res);
			      // out.println(res.length());
			       if (res.equals("1")) {
			   %>
			   	<jsp:forward page="CustomerDashBoard.jsp"/>
			   <%
			       } else {
			    	   out.println("Wrong");
			       }
		}
	%> 
</body>
</html>