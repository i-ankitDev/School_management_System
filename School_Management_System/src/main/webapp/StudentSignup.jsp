<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Sign Up</title>
</head>
<body>
<body>
	<form:form action="studentsignup" modelAttribute="student">
Name : <form:input path="name" />
		<br>
		<br>
Email : <form:input path="email" />
		<br>
		<br>
Passowrd : <form:password path="password" />
		<br>
		<br>
 Gender:   
        Male <form:radiobutton path="gender" value="Male" />  
        Female <form:radiobutton path="gender" value="Female" /> 
        Others <form:radiobutton path="gender" value="Others" />
		<br>
		<br>  
Date of Birth :<input type="date" name="db">
		<br>
		<br>
Status : <form:input path="status" readonly="true"/><br><br>
		<form:button>Submit</form:button>
		<input type="reset" value="Cancel">

	</form:form>
</body>
</body>


</html>