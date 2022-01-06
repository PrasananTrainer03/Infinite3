<%@page import="com.java.demo.Employ"%>
<%@page import="com.java.demo.EmployDAO"%>
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
		EmployDAO dao = new EmployDAO();
		int empno = dao.generateEmployNo();
	%>
	<form method="get" action="AddEmploy.jsp">
		<center>
			Employ No : 
			<input type="number" name="empno" value=<%=empno %> /> <br/><br/>
			Employ Name : 
			<input type="text" name="name" /> <br/><br/> 
			Gender :
			<select name="gender">
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
			</select> <br/><br/> 
			Department : 
			<input type="text" name="dept" /> <br/><br/>
			Designation : 
			<input type="text" name="desig" /> <br/><br/> 
			Basic : 
			<input type="number" name="basic" /> <br/><br/> 
			<input type="submit" value="Add Employ" />
		</center>
	</form>
	<%
		if (request.getParameter("empno")!=null &&  
			request.getParameter("name") !=null
				) {
	%>
		<jsp:useBean id="beanEmploy" class="com.java.demo.Employ"/>
		<jsp:setProperty property="*" name="beanEmploy"/>
		<%=dao.addEmploy(beanEmploy) %>
	<%
		}
	%>
	
</body>
</html>