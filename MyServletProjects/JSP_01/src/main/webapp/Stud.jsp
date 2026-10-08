<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green;text-align:center;">Student object details</h1>
	<jsp:useBean id="student" class="com.in.JspPage.Student" scope="page">
	<jsp:setProperty property="id" name="student"/>
	<jsp:setProperty property="name" name="student"/>
	<jsp:setProperty property="age" name="student"/>
	<jsp:setProperty property="address" name="student"/>
	<%--or--%>
	<%--jsp:setProperty property="address" name="student"/>--%>
	</jsp:useBean>
	<table border="1" align='center'>
	<thead>
		<tr>
		<th>id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Address</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td><jsp:getProperty property="id" name="student"/></td>
		<td><jsp:getProperty property="name" name="student"/></td>
		<td><jsp:getProperty property="age" name="student"/></td>
		<td><jsp:getProperty property="address" name="student"/></td>
		</tbody>
	</table>
	
</body>
</html>