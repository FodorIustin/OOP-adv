<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.work.Wood" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>All Doors table</h1>
	<% ArrayList<Wood> woods = (ArrayList<Wood>) request.getAttribute("woods"); %>
	<p>Number of doors: <%= woods.size() %> <p>
	
	<table border="l">
	<tr>
		<th>Id<th>
		<th>Height</th>
		<th>Width</th>
		<th>Material</th>
		<th>InstalaltionDate</th>
	</tr>
	<%for(Wood d : woods){ %>
	<tr>
		<td> <a href="doors/<%=d.getId()%>"><%=d.getId() %></a></td>
		<td><%=d.getHeight()%></td>
		<td><%=d.getWidth()%></td>
		<td><%=d.getMaterial()%></td>
		<td><%=d.getInstallationdate()%></td>
	</tr>
	<%} %>
	</table>
		<p><a href="doors/create">Create</a></p>
</body>
</html>