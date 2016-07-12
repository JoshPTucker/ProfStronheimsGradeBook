<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assignments</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<form action="Assignments" method="get">
		<input type="submit" id="Submit" name="submit" Value="assignments"></input>
	</form>
	<form action="GradebookServlet" method="post">
		<input type="submit" id="Submit" name="submit" Value="gradebook"></input>
	</form>
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
				<c:forEach var="averages" items="${sessionScope.averages }">
					<tr>
						<td><c:out value="${averages[0] }" /></td>
						<td><c:out value="${averages[1] }" /></td>
						<td><c:out value="${averages[2] }" /></td>
						<td><c:out value="${averages[3] }" /></td>
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
					<th>StudentId</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="allassignments" items="${allassignments }">
					<tr>
						<td><c:out value="${allassignments.assignmentname }" /></td>
						<td><c:out value="${allassignments.assignmenttype }" /></td>
						<td><c:out value="${allassignments.score }" /></td>
						<td><c:out value="${allassignments.assigneddate }" /></td>
						<td><c:out value="${allassignments.psstudent.studentid }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>