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
DETALII Book <br/>
<table>

	<tr>
		<td>Id</td>
		<td>${book.id}</td>
	</tr>
	<tr>
		<td>Title</td>
		<td>${book.title}</td>
	</tr>
	<tr>
		<td>Author</td>
		<td>${book.author}</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${book.price}</td>
	</tr>
	<td><a href="<c:url value="/books/all"/>">Inapoi</a></td>
</table>
</body>
</html>