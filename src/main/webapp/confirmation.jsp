<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<body>
<h1>Sign-Up Confirmation</h1>
<%
	String status = request.getParameter("status");
	String text = request.getParameter("test");
	if(status.equals("success")){
%>
	<p>Registration successfull!!, Thanks for signing up. <%=text %></p>
	<p>For login <a href="login.jsp">click here</a></p>
	
<%
	}else if(status.equals("error")){
%>
	<p>Registration faild, Try again!!! <a href="signup.html">click here</a></p>
	
<%
	}else if(status.equals("alreadyExist")){
		
%>
	<p>User Already registered. <a href="login.jsp">Login here</a></p>
	
<%
	}else {
%>
	<p>Unknown error, please contact Support</p>
<% 
	}
%>
</body>
</html>