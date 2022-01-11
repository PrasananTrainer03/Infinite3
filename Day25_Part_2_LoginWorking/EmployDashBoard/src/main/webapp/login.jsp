<%@page import="com.java.jsp.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="login.jsp">
		<table border="3" align="center">
		<tr>
			<th colspan="2">
				Login Page
			</th>
		</tr>
		<tr>
			<th>User Name</th>
			<td> 
				<input type="text" name="userName" /> 
			</td>
		</tr>
		<tr>
			<th>Password</th>
			<td>
				<input type="password" name="passWord" />
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Login" />
			</th>
		</tr>
		</table>
	</form>
	<%
		if (request.getParameter("userName")!=null && 
			request.getParameter("passWord") !=null
				) {
			String user = request.getParameter("userName").trim();
			String pwd = request.getParameter("passWord").trim();
			EmployDAO dao = new EmployDAO();
			int count = dao.loginCheck(user, pwd);
			if (count==1) {
	%>
		<jsp:forward page="EmployTable.jsp"/>
	<%
			} else {
				out.println("Invalid Credentials...");
			}
		}
	%>
</body>
</html>