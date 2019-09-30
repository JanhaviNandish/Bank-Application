<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="ChangePassword">
	<table>
		<tr>
			<td><label>Old password</label></td>
			<td><input type="password" name="PW" required />
		</td>
		<tr>
			<td><label>New password</label></td>
			<td><input type="password" name="NPW" required />
		</td>
		<tr>
			<td><label>Confirm new password</label></td>
			<td><input type="password" name="CPW" required />
		</td>
		<tr>
			
			<td><input type="submit" />
		</td>
		
	</table>
</form>

</body>
</html>