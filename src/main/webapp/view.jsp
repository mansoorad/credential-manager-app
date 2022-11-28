<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="user1" var="user">

<h3>User Name : ${user1.userName}</h3>
<h3>Email Id : ${user1.email}</h3>
<h3>Password : ${user1.password}</h3>
<h3>Address : ${user1.address}</h3>
<h3>Phone : ${user1.phone}</h3>




</c:forEach>

</body>
</html>