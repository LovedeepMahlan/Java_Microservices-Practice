<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style='color:green; text-align:center;'>Enter the data of Employee</h1>
<form method="post"  action="/employee/save">
<table>
	<tr>
		<th>EmployeeID</th>
		<td><input type="text" name="empId"></td>
	</tr>
	
	<tr>
		<th>EmployeeName</th>
		<td><input type="text" name="empName"></td>
	</tr>
	
	<tr>
		<th>EmployeeSalary</th>
		<td><input type="text" name="empSalary"></td>
	</tr>
	
	<tr>
		<th>EmployeePassword</th>
		<td><input type="text" name="empPassword"></td>
	</tr>
	
	<tr>
		<th>EmployeeDepartment</th>
		<td><input type="text" name="empDepartment"></td>
	</tr>
	
	<tr>
		<th>EmployeeAddress</th>
		<td><input type="text" name="empAddress"></td>
	</tr>
	
	<tr>
		<th>Press to Submit</th>
		<th><input type="submit" value="Submit"></th>
	</tr>
	
</table>
</form>
</body>
</html>