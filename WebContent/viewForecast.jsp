<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MainServlet" method="post">
<table>
<tr>
<td>Enter Location</td>
<td><input type="text" name="location"></td>
</tr>
<tr>
<td>Enter Date</td>
<td><input type="text" name="date"></td>
</tr>

</table>
<input type="hidden" name="command" value="viewforecast">
<input type=submit value="search">
</form>
</body>
</html>