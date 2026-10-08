<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<br><br><br>
	<c:choose>
		<c:when test="${student ne null || !empty student}">
			<table color="green" align="center" border="1">
				<tr>
				<th>StudentID</th>
				<th>StudentName</th>
				<th>StudentAge</th>
				<th>StudentAddress</th>	
			</tr>
			<tr>
				<td>${student.sid }</td>
				<td>${ student.sname}</td>
				<td>${ student.sage}</td>
				<td>${student.saddress}</td>
			</tr>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="text-align:center; color:Red">Data Not found for this Student ID</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>