	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Library</title>
	</head>
	<body>
	<h2>Books</h2>
	<table>
	<tr>
		
		<th>Id</th>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
	</tr>
	<c:forEach var="b" items="${books}" varStatus="idx"> 
	<tr ${idx.index%2==0? "style='background-color:grey;color:white'":"" }>
		
		<td><c:out value="${b.id}"/></td>
		<td><c:out value="${b.title}"/></td>
		<td><c:out value="${b.author}"/></td>
		<td><c:out value="${b.price}"/></td>
		<td><a href="<c:url value="/books/${b.id}"/>">Detalii</a></td>
		<td><a href="<c:url value="/books/edit/${b.id}"/>">Editeaza</a></td>
		<td><a href="<c:url value="/books/delete/${b.id}"/>">Sterge</a></td>
	 </tr>
	</c:forEach>
	</table>
	<a href="<c:url value="/books/add"/>">Creaza entitate</a>
	
	
		<br/>
		<!-- Display employees -->
<!-- Display employees -->
<h2>Employees</h2>
<table>
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    <c:forEach var="e" items="${employees}" varStatus="idx"> 
        <tr ${idx.index % 2 == 0 ? "style='background-color:grey;color:white'" : "" }>
            <td><c:out value="${e.employeeID}"/></td>
            <td><c:out value="${e.firstName}"/></td>
            <td><c:out value="${e.lastName}"/></td>
            <td><c:out value="${e.age}"/></td>
            <td><a href="<c:url value='/employees/${e.employeeID}'/>">Details</a></td>
            <td><a href="<c:url value='/employees/edit/${e.employeeID}'/>">Edit</a></td>
            <td><a href="<c:url value='/employees/delete/${e.employeeID}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/employees/add"/>">Creaza entitate</a>

<br/>
		<h2>Sections</h2>
<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Amount</th>
</tr>
<c:forEach var="s" items="${sections}" varStatus="idx"> 
<tr ${idx.index%2==0? "style='background-color:grey;color:white'":"" }>
	<td><c:out value="${s.idSection}"/></td>
	<td><c:out value="${s.name}"/></td>
	<td><c:out value="${s.amount}"/></td>
	<td><a href="<c:url value="/sections/${s.idSection}"/>">Detalii</a></td>
	<td><a href="<c:url value="/sections/edit/${s.idSection}"/>">Editeaza</a></td>
	<td><a href="<c:url value="/sections/delete/${s.idSection}"/>">Sterge</a></td>
 </tr>
</c:forEach>
</table>
<a href="<c:url value="/sections/add"/>">Creaza entitate</a>

	</body>
	</html>