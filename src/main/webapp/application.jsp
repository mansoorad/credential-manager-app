<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveapplication" modelAttribute="application">
	<form:label path="name">Application Name:</form:label>
	<form:input path="name"/>
	
	
	
	<input type="submit" value="login">
	
	</form:form>
</body>
</html>