<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Editare entitate</h1>
	<form:form method="post"
	 action="${pageContext.request.contextPath}/employee/edit"
	 modelAttribute="employee">
	 <label for="firstName">FirstName</label>
        <form:input path="firstName"/>
        
        <label for="lastName">LastName</label>
        <form:input path="lastName"/>
        
        <label for="age">Age</label>
        <form:input path="age"/>
        
        <label for="employeeID">ID</label>
        <form:input path="employeeID"/>
	 
	 <input type="submit" value="Salveaza"/> <br/>
	 
	</form:form>
</body>
</html>