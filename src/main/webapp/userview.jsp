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
<h3>Hi ${userName}</h3>
<table border="2px">
<tr>
<th>Id</th>
<th>ApplicationName</th>
<th>View</th>
<th>Delete</th>
<th>Edit</th>

<c:forEach items="${ulist}" var="user">
<tr>
<td>${user.id}</td>
<td>${user.applicationName}</td>
<td><a href="view?id=${user.id}">view</a></td>
<td><a href="delete?id=${user.id}">delete</a></td>
<td><a href="edit?id=${user.id}">edit</a></td>

</tr>


</c:forEach>
</tr>
</table>
</body>
</html>