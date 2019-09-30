<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Transfer</title>
</head>
<body>

<h1>enter valid amount</h1>
<form action="Transfer"></form>

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

</body>
</html>