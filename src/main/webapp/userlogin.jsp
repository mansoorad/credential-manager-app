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

	<form:form action="savelogin" modelAttribute="user">
	
	<form:label path="userName">UserName:</form:label>
	<form:input path="userName"/>
	
	<form:label path="password">Password:</form:label>
	<form:input path="password"/>
	
	<input type="submit" value="login">
	
	</form:form>
	
	
</body>
</html>