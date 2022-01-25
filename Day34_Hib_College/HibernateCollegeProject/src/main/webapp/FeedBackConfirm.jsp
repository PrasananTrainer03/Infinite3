<%@page import="com.java.hib.FeedBack"%>
<%@page import="com.java.hib.CollegeCrud"%>
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
	CollegeCrud obj = new CollegeCrud();
	String fid = obj.generateFeedbackId();
	String studentName = (String)session.getAttribute("studentName");
//	String subject = (String)session.getAttribute("subject");
String instructor = (String)session.getAttribute("instructor");
String subject = request.getParameter("subject");
String fbValue = request.getParameter("feedback");
out.println(fid);
out.println(studentName);
out.println(instructor);
out.println(subject);
out.println(fbValue);
FeedBack fb = new FeedBack();
fb.setFid(fid);
fb.setStudentName(studentName);
fb.setInstructor(instructor);
fb.setSubject(subject);
fb.setFbValue(fbValue);
out.println(obj.recordFeedback(fb));
%>
</body>
</html>