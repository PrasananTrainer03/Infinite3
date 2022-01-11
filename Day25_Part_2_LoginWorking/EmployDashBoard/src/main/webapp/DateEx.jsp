<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.jsp.Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="DateEx.jsp">
		Date of Birth : 
		<input type="date" name="dob" /> <br/><Br/>
		<input type="submit" value="Show" /> 
	</form>
	<%
		if (request.getParameter("dob")!=null) {
			Test obj = new Test();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = sdf.parse(request.getParameter("dob"));
			java.sql.Date db1 = new java.sql.Date(dob.getTime());
			obj.setDateOfBirth(db1);
		}
	%>
</body>
</html>