<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notes Form</title>
<%@ include file="header.jsp" %>
</head>
<body>
<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
	<div class="col-md-12 jumbotron">
		<fieldset>
			<marquee behavior="slide"><legend>Notes adding form </legend></marquee>
	<div>
		<fieldset style="width:500px">
			<form action="note_save" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label>Notes Title</label> <input type="text" name="nTitle" class="form-control">
				</div>
				<div class="form-group">
					<label>Targeted Notes Completion Date</label> <input type="date" name="nDate" class="form-control">
				</div>
				<div class="form-group">
					<label>About Notes</label> <textarea rows="5" cols="10"name="nAbout"class="form-control"></textarea>
				</div>
				<div class="form-group">
					<input type="submit" value="submit"class="btn btn-success">
				</div>
			</form>
		</fieldset>
		</div>
		<div class="col-md-2"></div>
		</fieldset>
		</div>
	</div>
</body>
</html>