<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>First Servlet Page</b>
	<%=new java.util.Date() %><br>
	 BookName is <%=request.getParameter("Book") %><br>
	 Amount is <%=request.getParameter("Amount") %>
</body>
</html>