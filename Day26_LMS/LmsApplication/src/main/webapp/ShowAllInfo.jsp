<%@page import="com.java.lms.EmployeeDAO"%>
<%@page import="com.java.lms.Employee"%>
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
    int empId=Integer.parseInt(request.getParameter("empno"));
	int mgrId = Integer.parseInt(request.getParameter("mgrid"));
	EmployeeDAO dao = new EmployeeDAO();
	Employee empDetails = dao.searchEmploy(empId);
	Employee mgrDetails = dao.searchEmploy(mgrId);
	
%>
	<table border="3" align="center">
		<tr>
			<th>Employee Details</th>
			<th>Manager Details</th>
		</tr>
		<tr>
			<td>
				Employee Id : <%=empDetails.getEmpId() %> <br/>
				Employee Name : <%=empDetails.getEmpName() %> <br/>
				Department : <%=empDetails.getEmpDept() %> <br/>
				Mobile : <%=empDetails.getEmpMobile() %> <br/>
				Email : <%=empDetails.getEmpEmail() %> <br/>
				Date of Join : <%=empDetails.getEmpDoj() %> <br/>
				Leave Balance : <%=empDetails.getLeaveAvail() %>
			 </td>
			<td> 
			Manager Id : <%=mgrDetails.getEmpId() %> <br/>
				Manager Name : <%=mgrDetails.getEmpName() %> <br/>
				Department : <%=mgrDetails.getEmpDept() %> <br/>
				Mobile : <%=mgrDetails.getEmpMobile() %> <br/>
				Email : <%=mgrDetails.getEmpEmail() %> <br/>
				Date of Join : <%=mgrDetails.getEmpDoj() %> <br/>
				Leave Balance : <%=mgrDetails.getLeaveAvail() %>
			</td>
		</tr>
	</table>
</body>
</html>