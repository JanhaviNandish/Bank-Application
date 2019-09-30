<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1>Registration form for applying loan  </h1>
<form action="loanSuccess.jsp"></form>
<table>
	<tr>
		<td><label>Name</label></td>
		<td><input type="text" name="NAME" required/></td>
	</tr>
	<tr>
		<td><label>DOB</label></td>
		<td><input type="date" name="DOB" required/></td>
	</tr>
	<tr>
		<td><label>Email</label></td>
		<td><input type="text" name="EMAIL" required/></td>
	</tr>
	<tr>
		<td><label>Phone</label></td>
		<td><input type="text" name="PH" required/></td>
	</tr>
	<tr>
		<td><label>Address</label></td>
		<td><input type="text" name="ADD" required/></td>
	</tr>
	<tr>
		<td><label>City</label></td>
		<td><input type="text" name="CIT" required/></td>
	</tr>
	<tr>
		<td><label>Country</label></td>
		<td><input type="text" name="CON" required/></td>
	</tr>
	<tr>
		<td><input type="Submit" value="SUBMIT" /></td>
	</tr>


</table>
</body>
</html>