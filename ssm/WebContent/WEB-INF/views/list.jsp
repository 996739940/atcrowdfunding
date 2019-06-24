<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSM helloworld</title>
</head>
<body>
	<h1>员工信息列表</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>gender</th>
			<th>DeptName</th>
			<th>Operation</th>
		</tr>
	
	<c:forEach items="${emps}" var="emp">
		<tr align="center">
			<td>${emp.id}</td>
			<td>${emp.lastName}</td>
			<td>${emp.email}</td>
			<td>${emp.gender}</td>
			<td>${emp.dept.deptName}</td>
			<td>
				<a href="#">DELETE</a>
				&nbsp;&nbsp;
				<a href="#">UPDATE</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	
	<h2 align="center"><a href="#">Add New Employee</a></h2>
	<br/>
	<h2 align="center">${pageString}</h2>
</body>
</html>