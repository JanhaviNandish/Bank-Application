<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
</head>
<body>
	<form action="Transfer">
	<table>
		<tr>
			<td><label>Third party account no</label></td>
			<td><input type="text" name="TPAC" required /></td>
		</tr>
		
		<tr>
			<td><label>Amount</label></td>
			<td><input type="text" name="AMT" required /></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Transfer" /></td>
			
		</tr>
	</table>
	</form>

</body>
</html>