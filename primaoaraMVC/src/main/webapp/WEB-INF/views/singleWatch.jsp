<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.Watch" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Single watch page</h1>
	
	<%Watch w = (Watch) request.getAttribute("wa"); %>
	<%if(w!=null){%>
		<p> Watch id: <%=w.getId() %><p>
		<p> Watch Brand: <%=w.getBrand() %><p>
		<p> Watch Price: <%=w.getPrice() %><p>
	 <% }%>
</body>
</html>