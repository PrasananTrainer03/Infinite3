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
	int empno = Integer.parseInt(request.getParameter("empno"));
	Employ employ = dao.searchEmploy(empno);
	if (employ!=null) {
		out.println("Employ Name  " +employ.getName() + "<br/>");
		out.println("Gender  " +employ.getGender().toString() + "<br/>");
		out.println("Department  " +employ.getDept() + "<br/>");
		out.println("Designation  " +employ.getDesig() + "<Br/>");
		out.println("Basic   " +employ.getBasic() + "<br/>");
	} else {
		out.println("*** Record Not Found ***");
	}
%>
</body>
</html>