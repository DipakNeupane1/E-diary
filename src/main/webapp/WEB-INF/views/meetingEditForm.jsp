<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meeting Update</title>
<%@ include file="header.jsp" %>
</head>
<body>
<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
	<div class="col-md-12 jumbotron">
		<fieldset>
			<marquee behavior="slide"><legend>Meeting Update form </legend></marquee>
	<div>
		<fieldset style="width:500px">
			<form action="meeting_edits?mid=${meet.mid}" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label>Meeting Title</label> <input type="text" name="mTitle" value="${meet.mTitle}"class="form-control">
				</div>
				<div class="form-group">
					<label>Meeting Focus Area</label> <input type="text" name="mFocusArea" value="${meet.mFocusArea}"class="form-control">
				</div>
				<div class="form-group">
					<label>Meeting Date</label> <input type="date" name="mDate"value="${meet.mDate}" class="form-control">
				</div>
				<div class="form-group">
					<label>Meeting Time</label> <input type="time" name="mTime"value="${meet.mTime}" class="form-control">
				</div>
				<div class="form-group">
					<label>Meeting Venue</label> <input type="text" name="mVenue" value="${meet.mVenue}"class="form-control">
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