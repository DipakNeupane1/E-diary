<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Edit Form</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
		<div class="col-md-12 jumbotron">
			<fieldset>
				<marquee behavior="slide">
					<legend> Friend Update form </legend>
				</marquee>
				<div>
					<fieldset style="width: 500px">
						<form action="friend_update?fid=${friend.fid}" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label>Friend Name</label> <input type="text" name="friendName"
									value="${friend.friendName}" class="form-control">
							</div>
							<div class="form-group">
								<label>Address</label> <input type="text" name="friendsAddress"
									value="${friend.friendsAddress}" class="form-control">
							</div>
							<div class="form-group">
								<label>DOB</label> <input type="date" name="dob"
									value="${friend.dob}" class="form-control">
							</div>
							<div class="form-group">
								<label>Phone Number</label> <input type="number"
									name="phoneNumber" value="${friend.phoneNumber}"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" name="email"
									value="${friend.email}" class="form-control">
							</div>
							<div class="form-group">
								<label>Gender</label> <input type="radio" name="gender"
									value="male"${friend.gender=='male'?'checked':''}>Male <input type="radio" name="gender"
									value="female"${friend.gender=='female'?'checked':''}>Female
							</div>
							<div class="form-group">
								<label>Photo</label> <input type="file" name="file"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="submit" value="submit" class="btn btn-success">
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