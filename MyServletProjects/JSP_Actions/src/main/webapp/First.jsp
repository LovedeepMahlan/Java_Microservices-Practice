<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		float bAmount =300.0f +(3000.0f*0.3f);
		System.out.println(bAmount);
	%>
	<jsp:forward page="Second.jsp">
	<jsp:param value="JSP" name="Book"/>
	<jsp:param value="<%=bAmount%>" name="Amount"/>
	</jsp:forward>
	
	<b>End of JSP Page</b>
</body>
</html>