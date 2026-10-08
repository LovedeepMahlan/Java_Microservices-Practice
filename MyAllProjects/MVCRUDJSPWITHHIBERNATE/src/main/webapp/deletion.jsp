<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br><br><br>
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="color:green; text-align:center;">Data has been deleted successfully</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color:Red; text-align:center;">Some exception has been came due to Data was not deleted.</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>