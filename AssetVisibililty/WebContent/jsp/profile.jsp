<!DOCTYPE html>
<%@ page import = "com.itemtracer.beans.UserBean"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ItemTracer.com - Total Asset Visibility</title>
	 <link rel="stylesheet" href="css/styleReport.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<%@include file="header.jsp" %>

	<section id="mission" class="section">
		<div class="container">
		 <div class="text-content">
			<h2 class="headline">My Profile</h2>
			<div class="tablecontainer">
			<table >

				<tr>
					<td>Username</td>
					<td>${sessionScope.user.userName}</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td>${sessionScope.user.firstName}</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>${sessionScope.user.lastName}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${sessionScope.user.email}</td>
				</tr>
				<tr>
					<td>Registration Date</td>
					<td>${sessionScope.user.timeStamp}</td>
				</tr>

			</table>
			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




