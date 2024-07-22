<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome to Student Dashboard</h1>
	<table border="1px" cellpadding="5">
		<tr>
			<th>S.no</th>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
		int i = 1;
		%>
		<c:forEach var="stu" items="${list }">
			<tr>
				<td><%=i++%></td>
				<td>${stu.getId() }</td>
				<td>${stu.getName() }</td>
				<td>${stu.getEmail() }</td>
				<td>${stu.getPassword() }</td>
				<td>${stu.getGender() }</td>
				<td>${stu.getDob() }</td>
				<td>${stu.getStatus() }</td>
				<td><a href="changeStatus?id=${stu.getId() }"><button>Change Status</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>