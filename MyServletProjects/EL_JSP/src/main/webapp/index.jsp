<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Name of Book is :: ${initParam.name}</h1><br>
	<h1>Price of Book is :: ${initParam.Price}</h1><br>
	
	<b>Working with Pagecontext Object</b>
	<h1>PageContext Object details :: ${pageContext}</h1>
	<h1>Session id :: ${pageContext.session.id }</h1>
	<h1>Request Method type is :: ${pageContext.request.method }</h1>
	<h1>HeaderName is :: ${header}</h1>
</body>
</html>