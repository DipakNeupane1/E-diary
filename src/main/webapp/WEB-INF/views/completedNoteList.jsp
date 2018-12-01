<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Note Trash</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h3>ALL Note Details Into Trash</h3>
	<c:if test="${!empty complete}">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>SN</th>
					<th>Note Id</th>
					<th>Note Title</th>
					<th>Targeted Notes Completion Date</th>
					<th>Something About Notes</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${complete}" var="completed" varStatus="c">
					<tr>
						<td>${c.count}</td>
						<td>${completed.nid}</td>
						<td>${completed.nTitle}</td>
						<td>${completed.nDate}</td>
						<td>${completed.nAbout}</td>
						<td><a href="completed_note_delete?nid=${completed.nid}"><button
									value="submit" class="btn btn-danger">Delete Permanently</button></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>