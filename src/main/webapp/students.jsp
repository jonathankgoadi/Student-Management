<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.studentmanagement.model.Student, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Student> students = (List<Student>)request.getAttribute("students"); %>
<%for(Student student: students){ %>
<%= student.getFirstName() %>
<%} %>
</body>
</html>