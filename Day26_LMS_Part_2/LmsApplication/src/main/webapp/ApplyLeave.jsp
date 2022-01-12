<%@page import="com.java.lms.LeaveType"%>
<%@page import="com.java.lms.LeaveStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.lms.LeaveDetails"%>
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
	int empId = Integer.parseInt(request.getParameter("empId"));
	LeaveDetailsDAO dao = new LeaveDetailsDAO();
%>
	<form method="get" action="ApplyLeave.jsp">
	<table border="3" align="center">
		<tr>
			<th colspan="2">
				Apply Leave
			</th>
		</tr>
		<tr>
			<th>Employ Id</th>
			<td> 
				<input type="number" name="empId" value=<%=empId %> />
			</td>
		</tr>
		<tr>
			<th>Leave StartDate</th>
			<td> 
				<input type="date" name="leaveStartDate" /> 
			</td>
		</tr>
		<tr>
			<th>Leave EndDate</th>
			<td>
				<input type="date" name="leaveEndDate" />
			</td>
		</tr>
		<tr>
			<th>Leave Type</th>
			<td> 
				<select name="leaveType">
					<option value="EL">EL</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>Leave Reason</th>
			<td>
				<input type="text" name="leaveReason" />
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Apply Leave" />
			</th>
		</tr>
	</table>
	</form>
	<%
		if (request.getParameter("empId")!=null &&
			request.getParameter("leaveStartDate") !=null &&
			request.getParameter("leaveEndDate")!=null
		
				) {
			LeaveDetails ld = new LeaveDetails();
			ld.setEmpId(empId);
			java.util.Date usDate = new 
					SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leaveStartDate"));
			java.sql.Date ssDate = new java.sql.Date(usDate.getTime());
			ld.setLeaveStartDate(ssDate);
			java.util.Date ueDate = new 
					SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leaveEndDate"));
			java.sql.Date seDate = new java.sql.Date(ueDate.getTime());
			ld.setLeaveEndDate(seDate);
			ld.setLeaveType(LeaveType.valueOf(request.getParameter("leaveType")));
		//	ld.setLeaveStatus(LeaveStatus.valueOf(request.getParameter("leaveType")));
			ld.setLeaveReason(request.getParameter("leaveReason"));
			dao.applyLeave(ld);
		%>
		<jsp:forward page="EmployShowAll.jsp"/>
		<%
		}
	%>
</body>
</html>