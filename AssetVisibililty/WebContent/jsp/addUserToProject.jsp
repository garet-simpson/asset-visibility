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
		
				<h3 class="headline">Manage Project Users</h3>
				<form action="addUserToProject" method="post">
					<br/>
					<label>Select user to add to project ${sessionScope.project.projectName }: </label> <br/>
					<select name="addUserName" id = "addUserName" >
					<c:forEach items="${requestScope.userNames}" var="userName" varStatus="loop">
						<option value = "${userName}"
							<c:if test="${requestScope.addUserName.equals(userName) }" >selected</c:if>
							><c:out value="${userName}"></c:out></option>
					</c:forEach>
					</select>
					<br/><br/>	
					<input name="getAuthority" type="submit" value="Get Authority" id="getAuthority">
					<br/><br/>	
					<label><c:if test="${requestScope.addUserToProjectMessage!= null}">${requestScope.addUserToProjectMessage}</c:if></label><br/>		
					<c:if test="${requestScope.authorityTypes!= null}">
					<select name="addUserProjectAuthority" id = "addUserProjectAuthority" ">
						<c:forEach items="${requestScope.authorityTypes}" var="authorityType" varStatus="loop">
							<option value = "${authorityType}"
								<c:if test="${requestScope.addUserProjectAuthority.equals(authorityType) }" >selected</c:if>
								><c:out value="${authorityType}"></c:out></option>
						</c:forEach>	
					</select>
					<br/><br/>
					<input name="submit" type="submit" value="Submit" id="submit">
					</c:if>
				
				</form>
				<c:if test="${requestScope.projectUserSummaryBean!=null}">
				<br/><br/>
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

							<tr>
								<td><c:out value="${projectUserSummaryBean.userName}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.firstName}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.lastName}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.projectName}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.projectDescription}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.projectAuthority}"></c:out></td>
								<td><c:out value="${projectUserSummaryBean.authorityDescription}"></c:out></td>
								
							</tr>

					</table>
		  			
				</c:if>
				<br/><br/><br/>
				<ul>
          			<li><a href="changeProject">Change Project</a></li> 
					<li><a href="newProject">Create New Project</a></li> 
          		</ul>
			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




