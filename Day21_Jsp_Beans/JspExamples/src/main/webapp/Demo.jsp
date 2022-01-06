<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean1" class="com.java.demo.DemoBean"/>
	Default Greeting : 
	<b>
		<jsp:getProperty property="greeting" name="bean1"/>
	</b>	
	<jsp:setProperty property="greeting" name="bean1" value="Good Evening..."/>
	<br/><br/>
	Updated Value : 
	<b>
		<jsp:getProperty property="greeting" name="bean1"/>
	</b>
</body>
</html>