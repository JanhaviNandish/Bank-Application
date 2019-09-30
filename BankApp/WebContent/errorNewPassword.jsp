<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error New Password</title>
</head>
<body>
<h2>New password and Confirm New Password fields are not matching. Try Again!!!</h2>

<form action="NewPassword">
	<table>
		<tr>
			<td><label>New Password</label></td>
			<td><input type="text" name="PWD" required/></td>
		</tr>
		<tr>
			<td><label>Confirm New Password</label></td>
			<td><input type="text" name="CPWD" required/></td>
		</tr>
		<tr>
			
			<td><input type="submit" /></td>
		</tr>
	</table>
</form>

</body>
</html>