<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hobbies</title>
</head>
<body>

	
	<h1>List of Hobbies</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		<a href="/SirSpringMVC">HOME</a><br>	<br>
      	<table border="1">
		<thead>
		<tr>
			<th>Hobby Id</th>
			<th>Hobby Name</th>
			<th> Action</th>
		</tr>
		</thead>
		
		<c:forEach items="${hblist}" var="cr"> 
		  <tr>
		    <td>${cr.hobbyId}</td>
		    <td>${cr.hobbyName}</td>
		    <td>
		<a href="/SirSpringMVC/hobby/update/<c:out value="${cr.hobbyId}"></c:out>">EDIT</a>
		<a href="/SirSpringMVC/hobby/delete/<c:out value="${cr.hobbyId}"></c:out>">DELETE</a>
		  </td>
		  </tr>
		</c:forEach>
		</table>  
</body>
</html>