<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Registration Form</title>
<%@ include file="header.jsp" %>
</head>
<body>
<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
	<div class="col-md-12 jumbotron">
		<fieldset>
			<marquee behavior="slide"><legend> Friends adding form </legend></marquee>
	<div>
		<fieldset style="width:500px">
			<form action="friend_save?id=${id}" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label>Friend Name</label> <input type="text" name="friendName" class="form-control">
				</div>
				<div class="form-group">
					<label>Address</label> <input type="text" name="friendsAddress" class="form-control">
				</div>
				<div class="form-group">
					<label>DOB</label> <input type="date" name="dob" class="form-control">
				</div>
				<div class="form-group">
					<label>Phone Number</label> <input type="number" name="phoneNumber" class="form-control">
				</div>
				<div class="form-group">
					<label>Email</label> <input type="email" name="email" class="form-control">
				</div>
				<div class="form-group">
					<label>Gender</label> <input type="radio" name="gender"
						value="male">Male <input type="radio" name="gender"
						value="female">Female
				</div>
				<div class="form-group">
					<label>Photo</label> <input type="file" name="file" class="form-control">
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