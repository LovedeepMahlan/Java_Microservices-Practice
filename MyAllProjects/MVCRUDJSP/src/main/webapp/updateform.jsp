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
		<c:when test="${Student ne null || !empty student }">
			<form action="./controller/editrecord" method="post">
			<table align="center">
				<tr>
					<th>STUDENT ID</th>
					<td><input type='text' name="sid" readonly="readonly" value='${Student.sid}'/></td>
				</tr>
				<tr>
					<th>STUDENT NAME</th>
					<td><input type='text' name="sname"  value='${Student.sname}'/></td>
				</tr>
				<tr>
					<th>STUDENT AGE</th>
					<td><input type='text' name="sage"  value='${Student.sage}'/></td>
				</tr>
				<tr>
					<th>STUDENT ADDRESS</th>
					<td><input type='text' name="saddress"  value='${Student.saddress}'/></td>
				</tr>
				<tr>
					<th></th>
					<td> <input type='submit' value="update" /></td>
				</tr>
			</table></form>
		</c:when>
	</c:choose>
</body>
</html>