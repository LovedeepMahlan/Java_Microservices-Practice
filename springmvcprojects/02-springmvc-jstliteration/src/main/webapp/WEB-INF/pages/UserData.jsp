<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core"	 prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Data Of Single User is ::${user}
	</h1>
	<p> user id is   :: ${user.uId}</p>
	<p> user name is :: ${user.uName }</p>
	<p> user role is :: ${user.uRole }</p>
	
	<h2>Iteration of All Users</h2>
	<table>
		<tr> 
			<th>UserID</th>
			<th>UserName</th>
			<th>UserRole</th>
		</tr>
		
		<c:forEach items="${ListObject}" var="obj"> 
			<tr>
				<td> ${obj.uId}</td>
				<td> ${obj.uName}</td>
				<td> ${obj.uRole}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>