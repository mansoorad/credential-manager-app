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
<body>
   <form:form action="saveuser" modelAttribute="user">
   
   <form:label path="name">Name:</form:label>
   <form:input path="name"/>
   
    <form:label path="address">Address:</form:label>
    <form:input path="address"/>
   
    <form:label path="email">Email:</form:label>
    <form:input path="email"/>
   
    <form:label path="password">Password:</form:label>
    <form:input path="password"/>
   
    <form:label path="phone">Phone:</form:label>
   <form:input path="phone"/>
   
   
   
   <input type="submit" value="submit">

   
   
   
   </form:form>
</body>
</html>