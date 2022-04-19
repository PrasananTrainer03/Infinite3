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
		int eno = Integer.parseInt(request.getParameter("empno"));
		EmployDAO dao= new EmployDAO();
		Employ employ = dao.searchEmploy(eno);
	%>
	<form method="get" action="UpdateEmploy.jsp">
		<center>
			Employ Number : 
			<input type="number" readonly="readonly" name="empno" value=<%=eno %> /> <br/><br/> 
			Employ Name : 
			<input type="text" name="name" value=<%=employ.getName() %> /> <br/><br/> 
			Gender : 
			<input type="text" name="gender" value=<%=employ.getGender() %> />
			 <br/><br/> 
			Department :
			<input type="text" name="dept" value=<%=employ.getDept() %> /> <br/><br/> 
			Designation : 
			<input type="text" name="desig" value=<%=employ.getDesig() %> /><br/><br/> 
			Basic : 
			<input type="number" name="basic" value=<%=employ.getBasic() %> /><br/><br/>
			<input type="submit" value="Update Employ" />
		</center>
	</form>
	<%
	if (request.getParameter("empno")!=null && request.getParameter("basic")!=null) {
		Employ emp = new Employ();
		emp.setEmpno(eno);
		emp.setName(request.getParameter("name"));
		String gen = request.getParameter("gender");
		if (gen.toUpperCase().equals("MALE")) {
			emp.setGender(Gender.MALE);
		} else {
			emp.setGender(Gender.FEMALE);
		}
		emp.setDept(request.getParameter("dept"));
		emp.setDesig(request.getParameter("desig"));
		emp.setBasic(Integer.parseInt(request.getParameter("basic")));
		dao.updateEmploy(emp);
	%>
	<jsp:forward page="EmployTable.jsp"/>
	<%
	}
	%>
</body>
</html>