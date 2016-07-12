<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" scope="session"></fmt:setLocale>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GradeBook</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<script language="JavaScript">
<!--
function Hello()
 {
 alert("Welcome To Your GradeBook!")
 }//-->
</script>
</head>
<body onload="Hello()">
	<div align="left">
		<form action="GradebookServlet" method="post">
			<input type="submit" id="Submit" name="submit" Value="gradebook"></input>
		</form>
		<form action="Assignments" method="post">
			<input type="submit" id="Submit" name="submit" Value="assignments"></input>
		</form>
	</div>
	<div class="dropdown" align="left">
		<button class="btn btn-default dropdown-toggle" type="button"
			id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="true">
			options <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			<li>
				<form action="GradebookServlet" method="get">
					<input type="number" id="studentid" value=" " name="studentid"></input>
					<input type="submit" id="Submit" name="submit" Value="enter"></input>
				</form>
			</li>

		</ul>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover"
			style="background-color: lightblue">
			<thead>
				<tr>
					<th>StudentId</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="students" items="${students }">
					<tr>
						<td><c:out value="${students.studentid }" /></td>
						<td><c:out value="${students.firstname }" /></td>
						<td><c:out value="${students.lastname }" /></td>
						<td><c:out value="${students.gradeavg }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>