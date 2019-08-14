<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<h2 class="headline">Project</h2>
			<p></p>
			<div class="tablecontainer">
		
				<h3 class="headline">Create New Project</h3>
					<br/>
				     <form action="newProject" method="post">
					<label>Project Name</label> <input type="text" name="newProjectName" id="newProjectName"><br/><br/>
					<label>Project Description</label> <input type="text" name="newProjectDescription" id="newProjectDescription"><br/><br/>
					<input type="submit" value="Submit" id="submit">
				</form>
				
				<p><c:if test="${requestScope.newProjectMessage!= null}">${requestScope.newProjectMessage}</c:if></p>
				<c:if test="${requestScope.newProject!= null}">
					<table >
							<tr>
								<th>Project Id</th>
								<th>Project Name</th>
								<th>Project Description</th>
								<th>Creation Date</th>
								<th>Author</th>
								
							</tr>
								<tr>
									<td>${requestScope.newProject.projectId}</td>
									<td>${requestScope.newProject.projectName}</td>
									<td>${requestScope.newProject.projectDescription}</td>
									<td>${requestScope.newProject.timeStamp}</td>
									<td>${requestScope.newProject.authorUserId}</td>
									
								</tr>
						</table>
				</c:if>
				<p></p>
				<br/><br/><br/>
				<ul>
          			<li><a href="changeProject">Change Project</a></li> 
					<li><a href="addUserToProject">Manage Project Users</a></li> 
          		</ul>
			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




