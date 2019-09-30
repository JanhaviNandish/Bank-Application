<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<h1>You have successfully logged out!!!</h1>
<br/>
<a href="home.html">Click here to Login</a>
<%
	session.invalidate();    //session data will be cleared
%>
</body>
</html>