<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
DETALII Section <br/>
<table>

	<tr>
		<td>Id</td>
		<td>${section.idSection}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${section.name}</td>
	</tr>
	<tr>
		<td>Amount</td>
		<td>${section.amount}</td>
	</tr>
	<td><a href="<c:url value="/books/all"/>">Inapoi</a></td>
</table>
</body>
</html>