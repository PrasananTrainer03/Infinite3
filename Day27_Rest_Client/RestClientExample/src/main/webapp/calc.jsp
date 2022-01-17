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
	<form method="get" action="calc.jsp">
		<center>
			First No : 
			<input type="number" name="firstNo" /> <br/><br/> 
			Second No : 
			<input type="number" name="secondNo" /> <br/><br/> 
			<input type="submit" value="Calc" />
		</center>
	</form>
	<%
		if (request.getParameter("firstNo")!=null && request.getParameter("secondNo") !=null) {
			int firstNo, secondNo, result;
			firstNo = Integer.parseInt(request.getParameter("firstNo"));
			secondNo = Integer.parseInt(request.getParameter("secondNo"));
			
			 URL url = new URL("http://localhost:8080/RestServiceExample/webapi/calc/sum/" +firstNo+"/"+secondNo);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "text/plain");

		        if (conn.getResponseCode() != 200) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                    + conn.getResponseCode());
		        }
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(
			            (conn.getInputStream())));

			        String output;
			        out.println("Sum  ");
			        while ((output = br.readLine()) != null) {
			            out.println(output);
			        }
			        
			        out.println("<br/><br/>");
			        
			        URL url1 = new URL("http://localhost:8080/RestServiceExample/webapi/calc/sub/" +firstNo+"/"+secondNo);
			        HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
			        conn1.setRequestMethod("GET");
			        conn1.setRequestProperty("Accept", "text/plain");

			        if (conn1.getResponseCode() != 200) {
			            throw new RuntimeException("Failed : HTTP error code : "
			                    + conn1.getResponseCode());
			        }
			        
			        BufferedReader br1 = new BufferedReader(new InputStreamReader(
				            (conn1.getInputStream())));

				        String output1;
				        out.println("Sub  ");
				        while ((output1 = br1.readLine()) != null) {
				            out.println(output1);
				        }

				        out.println("<br/><br/>");
				        
				        URL url2 = new URL("http://localhost:8080/RestServiceExample/webapi/calc/mult/" +firstNo+"/"+secondNo);
				        HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
				        conn2.setRequestMethod("GET");
				        conn2.setRequestProperty("Accept", "text/plain");

				        if (conn2.getResponseCode() != 200) {
				            throw new RuntimeException("Failed : HTTP error code : "
				                    + conn2.getResponseCode());
				        }
				        
				        BufferedReader br2 = new BufferedReader(new InputStreamReader(
					            (conn2.getInputStream())));

					        String output2;
					        out.println("Mult  ");
					        while ((output2 = br2.readLine()) != null) {
					            out.println(output2);
					        }
				        
		}
	%>
</body>
</html>