<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Note List</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h3>Note Details</h3>
	<a href="addNoteForm">Add New Notes</a>
	<c:if test="${!empty notes}">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>SN</th>
					<th>Note Id</th>
					<th>Note Title</th>
					<th>Targeted Notes Completion Date</th>
					<th>Something About Notes</th>
					<th>Notes Status</th>
					<th>Actions</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notes}" var="note" varStatus="n">
					<tr>
						<td>${n.count}</td>
						<td>${note.nid}</td>
						<td>${note.nTitle}</td>
						<td>${note.nDate}</td>
						<td>${note.nAbout}</td>
						<td><a href="note_status?nid=${note.nid}"><button value="submit"class="btn btn-success">Move into Trash</button></a></td>
						<td><a href="note_edit?nid=${note.nid }"><button value="submit"class="btn btn-warning">Edit Note</button></a>  <a
							href="note_delete?nid=${note.nid }"><button value="submit"class="btn btn-danger">Delete Note</button></a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>