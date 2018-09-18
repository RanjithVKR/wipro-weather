<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewForecast</title>
</head>
<body>
<form name = "view" action = "MainServlet" method = "post" >
<table>
	<tr>
	<td>Location</td>
	<td><input type = "text" name = "location" ></td>
	</tr>
	<tr>
	<td>Date</td>
	<td><input type = "text" name = "date" ></td>
	</tr>
</table>
<input type = "hidden" name = "command" value = "viewForcast">
<input type = "submit" value = "SEARCH">
</form>
</body>
</html>