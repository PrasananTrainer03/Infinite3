<%@ page errorPage="Error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="Division.jsp">
		<center>
			First No : 
			<input type="number" name="firstNo" /> <br/><br/>
			Second No : 
			<input type="number" name="secondNo" /> <br/><br/> 
			<input type="submit" value="Division" /> <br/><br/> 
		</center>
	</form>
	<%
		if (request.getParameter("firstNo")!=null && 
			request.getParameter("secondNo") !=null
				) {
			int firstNo, secondNo, result;
			firstNo = Integer.parseInt(request.getParameter("firstNo"));
			secondNo = Integer.parseInt(request.getParameter("secondNo"));
			result = firstNo / secondNo;
			out.println("Result is   " +result);
		}
	%>
</body>
</html>