<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		if (user.equals("Anmol") && pwd.equals("Dalela")) {
	%>
		<jsp:forward page="Menu.jsp"/>
	<%
			//out.println("Correct Credentials...");
		} else {
	%>
		<jsp:include page="Login.html"/>
	<%
			out.println("Invalid Credentials...");
		}
	%>
</body>
</html>