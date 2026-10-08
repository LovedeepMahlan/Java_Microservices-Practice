<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, in.pwskills.nitin.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OPERATORS IN JSP</title>
</head>
<body>
  <h1> Working with Arrays</h1>
  <%
  	String[] names = {"sachin","kohli","dhoni","dravid"};
  	pageContext.setAttribute("name", names);//pageScope
  %>
  
  <h1>
  	${name[0]}<br>
  	${name['1'] }<br>
  	${name["2"] }<br>
  	${name[5] }
  </h1>
  
  <hr>
  
  <h1> Working with ArrayList</h1>
  <%
  	ArrayList<String> al = new ArrayList<>();
  	al.add("Nitin");
  	al.add("Naveen");
  	al.add("Gagan");
  	al.add("Manjunath");
  	pageContext.setAttribute("stdName", al);
  	pageContext.setAttribute("index",3);
  %>
  <h1>
  	${stdName[0]}<br>
  	${stdName["1"]}<br>
  	${stdName['2']}<br>
  	${stdName[5]}<br>
  	${stdName[index] }	
  </h1>
  
  <%
  	ArrayList<Student> stdList =new ArrayList<Student>();
  
  	pageContext.setAttribute("student", stdList);
  %>
  <h1>StudentList :: ${empty student }</h1>	
  
  <hr>
  <h1>EL versus null</h1>
  <h1>${10+null}</h1>
  <h1>${empty null}</h1>
  <h1>${!null}</h1>
</body>
</html>