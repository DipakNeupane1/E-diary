<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meeting List</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h3>Completed Meetings Details</h3>
	<c:if test="${!empty meet}">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>SN</th>
					<th>Meeting Id</th>
					<th>Meeting Title</th>
					<th>Meeting Focus Area</th>
					<th>Date Of Meeting</th>
					<th>Time Of Meeting</th>
					<th>Meeting Venue</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${meet}" var="meeting" varStatus="m">
					<tr>
						<td>${m.count}</td>
						<td>${meeting.mid}</td>
						<td>${meeting.mTitle}</td>
						<td>${meeting.mFocusArea}</td>
						<td>${meeting.mDate}</td>
						<td>${meeting.mTime}</td>
						<td>${meeting.mVenue}</td>
<td><a href="completed_meeting_delete?mid=${meeting.mid }"><button value="submit" class="btn btn-danger">Delete Meeting</button></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>