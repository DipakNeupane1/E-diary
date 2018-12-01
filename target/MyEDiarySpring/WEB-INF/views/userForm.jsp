<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User SignUp</title>
<%@include file="LandingPage.jsp"%>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
		<div class="col-md-12 jumbotron">
			<marquee behavior="slide">
				<legend>User Registration Form </legend>
			</marquee>
			<div>
				<fieldset style="width: 500px">
					<form action="save_user" method="post"
						enctype="multipart/form-data">
						<h5>
				<span style="color: #ff0000; font-size: 18px;">${error}</span>
			</h5>
						<div class="form-group">
							<label>First Name</label> <input type="text" name="firstName"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Last Name</label> <input type="text" name="lastName"
								class="form-control"required="required">
						</div>
						<div class="form-group">
							<label>Address</label> <input type="text" name="address"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Username</label> <input type="text" name="userName"
								class="form-control"required="required">
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" name="password"
								class="form-control"required="required">
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" name="email"
								class="form-control"required="required">
						</div>
						<div class="form-group">
							<label>Photo Upload</label> <input type="file" name="file"
								class="form-control"required="required">
						</div>
						<div class="form-group">
							<input type="submit" value="submit" class="btn btn-success">
						</div>
					</form>
				</fieldset>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>