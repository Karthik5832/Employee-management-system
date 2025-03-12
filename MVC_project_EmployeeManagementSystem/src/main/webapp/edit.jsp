<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="edit" modelAttribute="employee">
	
	<form:label path="id">ENTER EMPLOYEE ID WHOSE DETAILS YOU WANT TO UPDATE: </form:label>
	<form:input path="id"/>
	<br>
	<br>
	<form:label path="name">ENTER NEW NAME: </form:label>
	<form:input path="name"/>
	<br>
	<br>
	<form:label path="phone">ENTER NEW PHONE NUMBER:</form:label>
	<form:input path="phone"/>
	<br>
	<br>
	<input type="submit" value="UPDATE EMPLOYEE">
	
	
	
	</form:form>
</body>
</html>