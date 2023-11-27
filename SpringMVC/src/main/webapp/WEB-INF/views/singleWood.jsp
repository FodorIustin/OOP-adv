<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.work.Wood" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Single watch page</h1>
	
	<%Wood w = (Wood) request.getAttribute("w"); %>
	<%if(w!=null){%>
		<p> Wood id: <%=w.getId() %><p>
		<p> Wood Height: <%=w.getHeight() %><p>
		<p> Wood Width: <%=w.getWidth() %><p>
		<p> Wood Material: <%=w.getWidth() %><p>
		<p> Wood Date: <%=w.getInstallationdate() %><p>
	 <% }%>
</body>
</html>