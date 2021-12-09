<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

	
	<h1>List of Employees</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		<a href="/SirSpringMVC">HOME</a><br>	<br>
      	<table border="1">
		<thead>
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Gender</th>
			<th>Employee Skills</th>
			<th>Employee City</th>
			<th>Employee Hobbies</th>
			<th> Action</th>
		</tr>
		</thead>
		
		<c:forEach items="${emplist}" var="cr"> 
		  <tr>
		    <td>${cr.empId}</td>
		    <td>${cr.empName}</td>
		    <td>${cr.empAge}</td>
		    <td>${cr.empSalary}</td>
		    <td>${cr.empGender}</td>
		    <td>${cr.empSkills}</td>
		    <td>${cr.empCity}</td>
		    <td>${cr.empHobbies}</td>
		    <td>
		<a href="/SirSpringMVC/employee/update/<c:out value="${cr.empId}"></c:out>">UPDATE</a>
		<a href="/SirSpringMVC/employee/delete/<c:out value="${cr.empId}"></c:out>">DELETE</a>
		  </td>
		  </tr>
		</c:forEach>
		</table>  
		
		
 <form:form method = "POST" action = "/SirSpringMVC/employee/search/" modelAttribute="empBean">
         <table>
            <tr>
               <td><form:label path = "empId">Employee Id to search: </form:label></td>
               <td><form:input path = "empId"/></td>
            </tr>
                   <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
      </table>
      </form:form>
</body>
</html>