<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String[] names = {"Anmol","Manasvi","Muskan","Jegan","Surya","Harshit"};
	pageContext.setAttribute("names", names);
%>
<c:forEach var="n" items="${names}">
	<c:out value="${n}"/> <br/>
</c:forEach>
</body>
</html>