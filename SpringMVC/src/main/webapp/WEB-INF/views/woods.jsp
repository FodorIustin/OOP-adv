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
	<%for(Woods w : woods){ %>
	<tr>
		<td> <a href="doors/<%=w.getId()%>"><%=w.getId() %></a></td>
		<td><%=w.getHeight()%></td>
		<td><%=w.getWidth()%></td>
		<td><%=w.getMaterial()%></td>
		<td><%=w.getDate()%></td>
	</tr>
	<%} %>
	</table>

</body>
</html>