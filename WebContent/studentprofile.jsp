<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<form action="GradebookServlet" method="post">
			<input type="submit" id="Submit" name="submit" Value="gradebook"></input>
		</form>
	</div>
	<div>
		<form action="StudentProfileServlet" method="get">
			<input type="submit" id="Submit" name="submit" Value="workdone"></input>
		</form>
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

				<tr>
					<td>${currstudent.studentid }</td>
					<td>${currstudent.firstname }</td>
					<td>${currstudent.lastname }</td>
					<td>${currstudent.gradeavg }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<form action="StudentProfileServlet" method="post">
			<input type="submit" name="submit" value="workdone" id="submit"></input>
		</form>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover"
			style="background-color: lightblue">
			<thead>
				<tr>
					<th>MinScore</th>
					<th>maxScore</th>
					<th>average</th>
					<th>type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="studentaverages" items="${sessionScope.studentaverages }">
					<tr>
						<td><c:out value="${studentaverages[0] }" /></td>
						<td><c:out value="${studentaverages[1] }" /></td>
						<td><c:out value="${studentaverages[1] }" /></td>
						<td><c:out value="${studentaverages[3] }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover"
			style="background-color: lightblue">
			<thead>
				<tr>
					<th>assignment Title</th>
					<th>Type</th>
					<th>Score</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="assignments" items="${assignments }">
					<tr>
						<td><c:out value="${assignments.assignmentname }" /></td>
						<td><c:out value="${assignments.assignmenttype }" /></td>
						<td><c:out value="${assignments.score }" /></td>
						<td><c:out value="${assignments.assigneddate }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>