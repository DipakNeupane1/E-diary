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
	<h3>Meetings Details</h3>
	<a href="addMeeting">Add Meeting</a>
	<c:if test="${!empty meeting}">
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
					<th>Meetings Status</th>
					<th>Actions</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${meeting}" var="meeting" varStatus="m">
					<tr>
						<td>${m.count}</td>
						<td>${meeting.mid}</td>
						<td>${meeting.mTitle}</td>
						<td>${meeting.mFocusArea}</td>
						<td>${meeting.mDate}</td>
						<td>${meeting.mTime}</td>
						<td>${meeting.mVenue}</td>
						<td><a href="send_status?mid=${meeting.mid}"><button value="submit"class="btn btn-success">Make Complete</button></a></td>
						<td><a href="meeting_edit?mid=${meeting.mid }"><button value="submit"class="btn btn-warning">Edit</button></a>  <a
							href="meeting_delete?mid=${meeting.mid }"><button value="submit"class="btn btn-danger">Delete</button></a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>