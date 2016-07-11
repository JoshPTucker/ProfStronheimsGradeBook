<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="en_US" scope="session"></fmt:setLocale>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Profile</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<div>
	<table class="table table-bordered table-striped table-hover" style="background-color:lightblue">
    <thead>
        <tr><th>StudentId</th><th>First Name</th><th>Last Name</th><th>Grade</th></tr>
    </thead>
    <tbody>
    <c:forEach var="currstudent" items="${student }">
        <tr><td><c:out value="${student.studentid }"/></td>
        <td><c:out value="${student.firstname }"/></td>
        <td><c:out value="${student.lastname }"/></td>
        <td><c:out value="${student.gradeavg }"/></td>
    </c:forEach>
    </tbody>
    </table>
    </div>
    <div>
	<table class="table table-bordered table-striped table-hover" style="background-color:lightblue">
    <thead>
        <tr><th></th><th>name</th><th>score</th><th>date</th></tr>
    </thead>
    <tbody>
    <c:forEach var="assignments" items="${assignments }">
        <tr><td><c:out value="${assignment.name }"/></td>
        <td><c:out value="${asssignment.type }"/></td>
        <td><c:out value="${assignment.score }"/></td>
        <td><c:out value="${assignment.date }"/></td>
    </c:forEach>
    </tbody>
    </table>
    </div>
</body>
</html>