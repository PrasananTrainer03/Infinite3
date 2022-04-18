<%@page import="com.java.jsp.Gender"%>
<%@page import="com.java.jsp.Employ"%>
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
<%
	EmployDAO dao = new EmployDAO();
	Employ employ = new Employ();
	employ.setEmpno(Integer.parseInt(request.getParameter("empno")));
	employ.setName(request.getParameter("name"));
	String gen = request.getParameter("gender");
	if (gen.toUpperCase().equals("MALE")) {
		employ.setGender(Gender.MALE);
	}
	if (gen.toUpperCase().equals("FEMALE")) {
		employ.setGender(Gender.FEMALE);
	}
	employ.setDept(request.getParameter("dept"));
	employ.setDesig(request.getParameter("desig"));
	employ.setBasic(Integer.parseInt(request.getParameter("basic")));
	out.println(dao.addEmploy(employ));
%>
</body>
</html>