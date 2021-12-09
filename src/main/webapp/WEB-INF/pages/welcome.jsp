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

	
	<h1>Add New Skill</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		<a href="/SirSpringMVC">HOME</a><br>	<br>
		
	 <form:form method = "POST" action = "/SirSpringMVC/skill/save/" modelAttribute="skillBean">
         <table>
            <tr>
               <td><form:label path = "skillId">Skill Id : </form:label></td>
               <td><form:input path = "skillId" readonly="true"/></td>
            </tr>
            
           <tr>
               <td><form:label path = "skillName">Skill Name :</form:label></td>
               <td><form:input path = "skillName" /></td>
            </tr>
            
             <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form> 
      
</body>
</html>