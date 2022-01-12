<%@page import="com.java.lms.LeaveDetailsDAO"%>
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
	int mgrId = Integer.parseInt(request.getParameter("empId"));
	int leaveId = Integer.parseInt(request.getParameter("leaveId"));
	
%>
	<form method="get" action="AcceptOrReject.jsp">
		<table border="3" align="center">
			<tr>
				<th>Leave Id </th>
				<td> <input type='number' name="leaveId" value=<%=leaveId %> /> </td>
			</tr>
			<tr>
				<th>Manager Id</th>
				<td> 
					<input type="number" name="empId" value=<%=mgrId %> /> 
				</td>
			</tr>
			<tr>
				<th>Manager Comments</th>
				<td>
					<input type="text" name="managerComments" /> 
				</td>
			</tr>
			<tr>
				<th>Status</th>
				<td>
				<select name="status">
					<option value="YES">Yes</option>
					<option value="NO">No</option>
				</select>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="Approve Leave" />
				</th>
			</tr>
		</table>
	</form>
	<%
		if (request.getParameter("leaveId")!=null && request.getParameter("empId")!=null
				&& request.getParameter("status")!=null
				) {
			LeaveDetailsDAO dao = new LeaveDetailsDAO();
			String mgrComments = request.getParameter("managerComments");
			String status = request.getParameter("status");
			dao.approveDeny(leaveId, mgrId, mgrComments, status);
	%>
		<jsp:forward page="EmployShowAll.jsp"/>
	<%
		}
	%>
</body>
</html>