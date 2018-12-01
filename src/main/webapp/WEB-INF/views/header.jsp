
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
</head>
<style>
.navbar-default {
	background-color: green;
}

.mr-auto>li>a {
	color:pink;
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
		<a class="navbar-brand" href="home"><span style="color:white;">E-DIARY</span></a>
<div><ul></ul></div>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="friends">FRIENDS AND ADD FRIENDS
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="birthdays">BIRTHDAYS</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="meetings">SCHEDULED MEETINGS </a></li>
				<li class="nav-item"><a class="nav-link" href="completedMeetings">COMPLETED MEETINGS
				</a></li>
				<li class="nav-item"><a class="nav-link" href="notes">NOTES</a></li>
				<li class="nav-item"><a class="nav-link"
					href="completed_notes">TRASH</a></li>
			</ul>

			<ul class=" nav navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link"><span
						style="color: red;">${username}</span></a>
						<li><img alt="pic" width="38px" height="50px" src="user_display_image?id=${id}"></li>
						<li class="nav-item"><a class="nav_link" href="change_pic?id=${id}"><span style="color: white;">=)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="logout"><button type="submit" class="btn btn-danger">Logout</button></a></li>
			</ul>


		</div>
	</nav>
</body>
</html>