<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Email Example</title>
<style type="text/css">
#sendEmailBtn {
	float: left;
	margin-top: 22px;
}
</style>
<%@ include file="header.jsp" %>
</head>
<div class="container col-md-offset-3 col-md-6 col-md-offset-3">
	<div class="col-md-12 jumbotron">
		<fieldset>
	<div class="form-group">
	<center>
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:blue">Send Email To Your Friends</span></h2>
		<form id="sendEmailForm" method="post" action="sendemail"
			enctype="multipart/form-data">
			<table id="emailFormBeanTable" border="0" width="80%">
				<tr>
					<td>Email To:</td>
					<td><input id="receiverMail" type="text" name="mailTo"
						size="65" value="${birthday.email}"class="form-control"/></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input id="mailSubject" type="text" name="subject"
						size="65" class="form-control"/></td>
				</tr>
				<tr>
					<td>Message:</td>
					<td><textarea id="mailMessage" cols="50" rows="10"
							name="message" class="form-control"></textarea></td>
				</tr>
				<tr>
					<td>Attachment:</td>
					<td><input id="mailAttachment" type="file"
						name="attachFileObj" size="60" class="form-control"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="sendEmailBtn"
						type="submit" value="Send Email" class="btn btn-success" /></td>
				</tr>
			</table>
		</form>
	</center>
	</div>
	<div class="col-md-2"></div>
</fieldset>
</div>
</div>
</html>