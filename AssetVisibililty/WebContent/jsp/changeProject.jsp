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
			<h3 class="headline">Change Project</h3>
			<p>Current Project: ${sessionScope.project.projectName}</p>
				<form action="changeProject" method="post">
				<label>Change to project: </label> 
				<select name="projectName" id = "projectName" onchange="this.form.submit()">
						<c:forEach items="${requestScope.projectNames}" var="projectName" varStatus="loop">
							<option value = "${projectName}"
								<c:if test="${sessionScope.project.projectName.equals(projectName) }" >selected</c:if>
								>${projectName}</option>
						</c:forEach>
				</select><br/><br/>
				</form><br/>
				
				<c:if test="${requestScope.changeProjectPermissionMessage!=null}">${requestScope.changeProjectPermissionMessage}</c:if>
				<c:if test="${requestScope.projectUserSummaryBeans!=null}">
					<table >
						<tr>
							<th>Username</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Project Name</th>
							<th>Project Description</th>
							<th>Project Authority</th>
							<th>Authority Description</th>
							
						</tr>
						<c:forEach items="${requestScope.projectUserSummaryBeans}" var="projectUserSummaryBean">
							<tr>
								<td>${projectUserSummaryBean.userName}</td>
								<td>${projectUserSummaryBean.firstName}</td>
								<td>${projectUserSummaryBean.lastName}</td>
								<td>${projectUserSummaryBean.projectName}</td>
								<td>${projectUserSummaryBean.projectDescription}</td>
								<td>${projectUserSummaryBean.projectAuthority}</td>
								<td>${projectUserSummaryBean.authorityDescription}</td>
								
							</tr>
						</c:forEach>
					</table>
		  			
				</c:if>
				<br/><br/><br/>
				<ul>

					<li><a href="newProject">Create New Project</a></li> 
					<li><a href="addUserToProject">Manage Project Users</a></li> 
          		</ul>
			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




