<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create door:</h1>
	
	<p>Insert wood:</p>
	<form action="/SpringMVC/doors/create" method="post">
		<input type="number" name="height"/>
		<input type="number" name="width"/>
		<input type="text" name="material"/>
		<input type="date" name="installationDate"/>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>