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

	<form:form action="delect" modelAttribute="employee">
	
		<form:label path="id">ENTER EMPLOYEE ID WHICH YOU WANT TO REMOVE: </form:label>
		<form:input path="id"/>
		<br>
		<br>
	
	
	</form:form>

</body>
</html>