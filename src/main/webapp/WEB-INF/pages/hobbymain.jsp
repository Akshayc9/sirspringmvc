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

	
	<h1>Add New Hobby</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		
		<a href="/SirSpringMVC">HOME</a><br>	<br>
		<c:if test="${not empty hblist }">
		      	<table border="1">
		<thead>
		<tr>
			<th>Hobby Id</th>
			<th>Hobby Name</th>
		</tr>
		</thead>
		
		<c:forEach items="${hblist}" var="cr"> 
		  <tr>
		    <td>${cr.hobbyId}</td>
		    <td>${cr.hobbyName}</td>
		  </tr>
		</c:forEach>
		</table>  
		</c:if>
	 <form:form method = "POST" action = "/SirSpringMVC/hobby/add/" modelAttribute="hbBean">
         <table>
            <tr>
               <td><form:label path = "hobbyId">Hobby Id : </form:label></td>
               <td><form:input path = "hobbyId" readonly="true"/></td>
            </tr>
            
           <tr>
               <td><form:label path = "hobbyName">Hobby Name :</form:label></td>
               <td><form:input path = "hobbyName" /></td>
            </tr>
            
             <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form> 
      
</body>
</html>