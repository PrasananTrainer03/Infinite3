<%@page import="java.util.Set"%>
<%@page import="com.java.hib.CollegeCrud"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CollegeCrud c=new CollegeCrud();
	//String fid=c.feedbackId();
	session.setAttribute("instructor","none");
	String fid = c.generateFeedbackId();
	
%>
<form method="get" name="frmFeedback" action="FeedBack.jsp">
<center>
FeedBack ID : 
	<input type="text" name="fid" readonly="readonly" value=<%=fid %> />
StudentName:
<input type="text" name="studentName"><br/><br/>
<!-- FB Value:
<input type="text" name="studentName"><br/><br/>
 -->Instructor : 
	<select name="instructor" onchange="change()">
	<option value="please Select">Please Select</option>
	<%
		Set<String> lstinstr=new CollegeCrud().getInstructors();
		for(String s : lstinstr){
	%>
	
		<option value="<%=s%>"> <%=s%> </option>
	
	<%
		}
	
	
			
	
	%>
	</select>
	<%

		String instr=request.getParameter("instructor");
		out.println(instr);
		session.setAttribute("instructor",instr);
		/* if(instr.equals("please Select")){
			out.println("Hello");	
		}
		else {
	  session.setAttribute("instructor",instr);
		}
		out.println("Server Value " +request.getParameter("instructor") + "<br/><br/>"); */
		
	%>

	
	<%-- <%
		session.setAttribute("subject",)
	%> --%>
	<br/>
	<input type="text" name="hidInstr" />
</center>
</form>
	   <script>
        function change(){
          //  frmFeedback.hidInstr.value=frmFeedback.instructor.value;
          /*  var instr=frmFeedback.instructor.value;
           frmFeedback.hidInstr.value=instr; */
           document.frmFeedback.submit();
      //     return true;
        }
        </script>


<%
	session.setAttribute("fid",fid);
    session.setAttribute("studentName",request.getParameter("studentName"));
  
    session.setAttribute("subject",request.getParameter("subject"));
   /*  session.setAttribute("feedback",request.getParameter("feedback")); */
    //out.println("Stored...");
%> 

Please give your feedback:
<form method="get" action="FeedBackConfirm.jsp">

	<br/><br/>
	select Subject : 
	<select name="subject">
	
		<%
		List<String> lstSubj=new CollegeCrud().getSubjects(instr);
		for(String s : lstSubj){
	%>
	
		<option value="<%=s%>"> <%=s%> </option>
	
	<%
		}
	%>
	</select> 
	
    <input type="radio" id="Choice1"
     name="feedback" value="Excellent">
    <label for="Choice1">Excellent</label>

    <input type="radio" id="Choice2"
     name="feedback" value="Good">
    <label for="Choice2">Good</label>

    <input type="radio" id="Choice3" 
     name="feedback" value="Adequate">
    <label for="Choice3">Adequate</label>

    <input type="radio" id="Choice4"
     name="feedback" value="Inadequate">
    <label for="Choice4">Adequate</label>
	<input type="submit" value="Confirm FeedBack" />
</form>
  </div>

 <%
	session.setAttribute("fid",request.getAttribute("fid"));
  //  session.setAttribute("studentName",request.getParameter("studentName"));
  
  //  session.setAttribute("subject",request.getParameter("subject"));
   // session.setAttribute("feedback",request.getParameter("feedback"));
%> 







</body>
</html>