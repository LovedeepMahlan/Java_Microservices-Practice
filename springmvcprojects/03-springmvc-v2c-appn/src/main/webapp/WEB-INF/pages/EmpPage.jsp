<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table style="border:1;align:center;color:green;">
	<tr>
		<th>EmployeeID</th>
		<td>${employee.empId}</td>
	</tr>
	<tr>
		<th>EmployeeName</th>
		<td>${employee.empName}</td>
	</tr>
	<tr>
		<th>EmployeeSalary</th>
		<td>${employee.empSalary}</td>
	</tr>
	<tr>
		<th>EmployeeDepartment</th>
		<td>${employee.empDepartment}</td>
	</tr>
	<tr>
		<th>EmployeeAddress</th>
		<td>${employee.empAddress}</td>
	</tr>
	<tr>
		<th>EmployeePassword</th>
		<td>${employee.empPassword}</td>
	</tr>
</table>
</body>
</html>