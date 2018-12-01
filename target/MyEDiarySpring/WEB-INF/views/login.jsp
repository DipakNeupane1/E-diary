<%@page import="javax.servlet.http.Cookie"%>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/popper.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
	<html><head><title>Login</title></head></html>

<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName().equals("uname")) {
			request.setAttribute("userName", c.getValue());
		} else if (c.getName().equals("pass")) {
			request.setAttribute("password", c.getValue());
		}
	}
%>
<div class="container">
	<div class="card card-container">

		<img id="profile-img" class="profile-img-card"
			src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />

		<form class="form-signin" action="login_user" method="post">
			<h5>
				<span style="color: #ff0000; font-size: 14px;">${message}</span>
			</h5>
			<input type="text" id="inputEmail" class="form-control"
				placeholder="Username" name="uname" required autofocus
				value="${userName}"> <input type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				name="pass" value="${password}" required>

			<div id="remember" class="checkbox">
				<label> <input type="checkbox" value="rememberMe"
					name="rememberMe"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Sign in</button>
				<button class="btn btn-lg btn-primary btn-block btn-signin"><a href="landing_page">Goto Langing Page</a></button>
		</form>
		<!-- /form -->

		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal" data-whatever="Forgot">Forgot
			the password?</button>
	</div>
	<!-- /card-container -->
</div>
<!-- /container -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">New message</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="forgotPassword" method="post">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Recipient:</label>
						<input type="text" class="form-control" name="toAddress"
							id="recipient-name">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Send
							message</button>
					</div>
					
				</form>
			</div>

		</div>
	</div>
</div>