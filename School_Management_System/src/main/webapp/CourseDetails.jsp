<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
</head>
<body>
	<h2>Select Your Course</h2>
<form:form action="addCourse" modelAttribute="course">
<form:select path="courseName">  
        <form:option value="Java Full Stack" label="Java Full Stack"/>  
        <form:option value="Manual Testing" label="Manual Testing"/>  
        <form:option value="Selenium" label="Selenium"/>  
        <form:option value="Web Tech" label="Web Tech"/>  
        </form:select>  
        <br><br>  
<form:button>Submit</form:button>
		<input type="reset" value="Cancel">
</form:form>
</body>
</html>