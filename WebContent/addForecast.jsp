<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Enter Weather Forecast Details</h3>
<form action="MainServlet" method="post">
<table>
<tr>
<td>Location</td>
<td><input type="text" name="location"></td>
</tr>
<tr>
<td>Date</td>
<td><input type="text" name="date"></td>
</tr>
<td>Temperature</td>
<td><input type="text" name="temperature"></td>
</tr>
<tr>
<td>Humidity</td>
<td><input type="text" name="humidity"></td>
</tr>
<tr>
<td>Wind</td>
<td><input type="text" name="wind"></td>
</tr>
<tr>
<td>Forecast</td>
<td><input type="text" name="forecast"></td>
</tr>
</table>
<input type="hidden" name="command" value="addforecast">
<button><a href="success.html">ADD</a></button>
</form>
</body>
</html>