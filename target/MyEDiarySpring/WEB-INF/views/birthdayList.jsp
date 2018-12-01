<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Birthday list</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h3>Friends Birthday List </h3>
	<c:if test="${!empty birthdays}">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>SN</th>
					<th>Friends Id</th>
					<th>Friend Name</th>
					<th style="color:red">Date Of Birth</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th style="color:blue">Birthday Wishes</th>
					<th>Photo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${birthdays}" var="birthday" varStatus="b">
					<tr>
						<td>${b.count}</td>
						<td>${birthday.fid}</td>
						<td>${birthday.friendName}</td>
						<td style="color:red">${birthday.dob}</td>
						<td>${birthday.phoneNumber}</td>
						<td>${birthday.email}</td>
						<td><a href="send_email?fid=${birthday.fid}"><button value="submit"class="btn btn-success">Make wishes</button></a></td>
						<td><img src="friend_display_image?fid=${birthday.fid}"
							alt="pic" width="50px" height="50px"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>