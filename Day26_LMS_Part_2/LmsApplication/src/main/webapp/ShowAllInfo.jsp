<%@page import="com.java.lms.LeaveDetails"%>
<%@page import="com.java.lms.LeaveDetailsDAO"%>
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
	LeaveDetails[] leaveHistory = new LeaveDetailsDAO().leaveHistory(empId);
	LeaveDetails[] pendingHistory = new LeaveDetailsDAO().pendingLeaves(empId);
%>
	<table border="3" align="center">
		<tr>
			<th>Employee Details</th>
			<th>Manager Details</th>;
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
			<%
				if (mgrDetails==null) {
					out.println("You Don't have Manager....");
				} else {
			%>
			Manager Id : <%=mgrDetails.getEmpId() %> <br/>
				Manager Name : <%=mgrDetails.getEmpName() %> <br/>
				Department : <%=mgrDetails.getEmpDept() %> <br/>
				Mobile : <%=mgrDetails.getEmpMobile() %> <br/>
				Email : <%=mgrDetails.getEmpEmail() %> <br/>
				Date of Join : <%=mgrDetails.getEmpDoj() %> <br/>
				Leave Balance : <%=mgrDetails.getLeaveAvail() %>
			</td>
			<%
				}
			%>
		</tr>
		<tr>
			<td>
				<table border="3">
					<tr>
						<th>Leave ID</th>
						<th>No.Of Leaves Taken </th>
						<th>Manager Comments</th>
						<th>Employ Id</th>
						<th>Leave Start Date</th>
						<th>Leave End Date</th>
						<th>Leave Type</th>
						<th>Leave Status</th>
						<th>Leave Reason</th>
					</tr>
					<%
						for(LeaveDetails ld : leaveHistory) {
					%>
						<tr>
							<td><%=ld.getLeaveId() %>  </td>
							<td><%=ld.getNoOfDays() %>  </td>
							<td><%=ld.getManagerComments() %> </td>
							<td><%=ld.getEmpId() %> </td>
							<td><%=ld.getLeaveStartDate() %> </td>
							<td><%=ld.getLeaveEndDate() %> </td>
							<td><%=ld.getLeaveType() %> </td>
							<td><%=ld.getLeaveStatus() %> </td>
							<td><%=ld.getLeaveReason() %> </td>
						</tr>
					<%
						}
					%>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="3">
					<tr>
						<th>Leave ID</th>
						<th>No.Of Leaves Taken </th>
						<th>Manager Comments</th>
						<th>Employ Id</th>
						<th>Leave Start Date</th>
						<th>Leave End Date</th>
						<th>Leave Type</th>
						<th>Leave Status</th>
						<th>Leave Reason</th>
					</tr>
					<%
						for(LeaveDetails ld : pendingHistory) {
					%>
						<tr>
							<td><%=ld.getLeaveId() %>  </td>
							<td><%=ld.getNoOfDays() %>  </td>
							<td><%=ld.getManagerComments() %> </td>
							<td><%=ld.getEmpId() %> </td>
							<td><%=ld.getLeaveStartDate() %> </td>
							<td><%=ld.getLeaveEndDate() %> </td>
							<td><%=ld.getLeaveType() %> </td>
							<td><%=ld.getLeaveStatus() %> </td>
							<td><%=ld.getLeaveReason() %> </td>
						</tr>
					<%
						}
					%>
				</table>
			</td>
		</tr>
	</table>
	<a href="ApplyLeave.jsp?empId=<%=empId %>">Apply Leave</a>
</body>
</html>