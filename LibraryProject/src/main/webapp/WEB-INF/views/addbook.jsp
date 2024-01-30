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
<h1> Creare entitate</h1>
<form:form method="post" 
	action="${pageContext.request.contextPath}/books/add"
	modelAttribute="book">
	
	<label for="title">Title</label>
	<form:input path="title"/>
	
	
	<label for="author">Author</label>
	<form:input path="author"/>
	
	<label for="price">Price</label>
	<form:input path="price"/>
	
	<input type="submit" value="Salveaza" /><br/>

</form:form>
</body>
</html>