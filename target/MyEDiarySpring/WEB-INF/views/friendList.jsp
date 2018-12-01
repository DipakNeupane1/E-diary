<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends list</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h3>Friend Details</h3>
	<a href="addfriend">Add Friends</a>
	<c:if test="${!empty friends}">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>SN</th>
					<th>Friends Id</th>
					<th>Friend Name</th>
					<th>Address</th>
					<th>DOB</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Photo</th>
					<th>Actions</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${friends}" var="friend" varStatus="f">
					<tr>
						<td>${f.count}</td>
						<td>${friend.fid}</td>
						<td>${friend.friendName}</td>
						<td>${friend.friendsAddress}</td>
						<td>${friend.dob}</td>
						<td>${friend.phoneNumber}</td>
						<td>${friend.email}</td>
						<td>${friend.gender}</td>
						<td><img src="friend_display_image?fid=${friend.fid}"
							alt="pic" width="50px" height="50px"></td>
						<td><a href="friend_edit?fid=${friend.fid }"><button value="submit"class="btn btn-warning">Edit Friend </button></a>  <a
							href="friend_delete?fid=${friend.fid }"><button value="submit"class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>