<%@page import="com.wipro.weather.bean.WeatherBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.weather.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, td {
    border: 1px solid black;
    border-collapse: collapse;
}
td{
padding:10px;
}
</style>
</head>
<body>
<% 
if(session.getAttribute("name").equals("fail")){%>
<p>Error</p>
<% 
	
}
else
{
	WeatherBean al1=(WeatherBean)session.getAttribute("name");
	%><table >
	<tr>
	<td>
	<%=al1.getReportId() %></td>
	<td><%=al1.getLocation() %></td>
	<td><%=al1.getDate() %></td>
	<td><%=al1.getTemperature() %></td>
	<td><%=al1.getHumidity() %></td>
	<td><%=al1.getWind() %></td>
	<td><%=al1.getForecast() %>
	</td>
	</tr>
	</table>	
<%}
%>
</body>
</html>