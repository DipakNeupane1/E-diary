
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing Page</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
</head>
<style>
.navbar-default {
	background-color:blue;
}

.mr-auto>li>a {
	color: white;
}

.nav-link {
	color: white;
}

.navbar-brand {
	color: white;
}
</style>
<body>

	<nav class="navbar navbar-expand-lg navbar-default">
		<a class="navbar-brand" href="landing_page"><span style="color:white">E-Diary</span></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			
			</ul>

			<ul class=" nav navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="login"><span
						style="color:white;">Login</span></a>
						<li class="nav-item"><a class="nav-link" href="signup"><span
						style="color:white;">SignUp</span></a>
				<li class="nav-item"><a class="nav-link"href="AboutUs"><span
						style="color: white;">About</span></a>
				<li class="nav-item"><a class="nav-link" href="contactUs"><span
						style="color: white;">Contacts</span></a></li>
			</ul>
</div>
	</nav>
	<img alt="image" height="50%" width="100%" src="resources/bootstrap/front-image.jpeg">
</body>
</html>