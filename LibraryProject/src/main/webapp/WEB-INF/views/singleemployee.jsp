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
<h1>Employee Details</h1>
    <table>
        <tr>
            <td>ID</td>
            <td>${employee.employeeID}</td>
        </tr>
        <tr>
            <td>First Name</td>
            <td>${employee.firstName}</td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>${employee.lastName}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${employee.age}</td>
        </tr>
    </table>
	<td><a href="<c:url value="/books/all"/>">Inapoi</a></td>
</table>
</body>
</html>