<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ItemTracer.com - Total Asset Visibility</title>
	<link href="css/styleDashboard.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<header id="home" class="header">
  <nav class="nav" role="navigation">
    <div class="container nav-elements">
      <div class="branding"><br>
        <a href="dashboard">ItemTracer.com</a><br>
      </div>

      <!-- branding -->
      <ul class="navbar">
        <li><a href="dashboard">dashboard</a></li>
        <li><div class="dropdown"><a href="projects">projects</a>
        	<div class="dropdown-content">
			<a href="changeProject">change project</a>
			<a href="newProject">create new project</a> 
			<a href="addUserToProject">manage project users</a>
        	</div></div></li>  
        <li><div class="dropdown"><a href="parts">parts</a>
        	<div class="dropdown-content">
			<a href="newPart">add new part</a>
			<a href="updatePart">update part</a> 
        	</div></div></li>  
        <li><a href="#mission">move items</a></li>
        <li><div class="dropdown"><a href="reports">reports</a>
        	<div class="dropdown-content">
        	<a href="partHistoryReport">part history report</a>
        	<a href="stockListingReport">stock listing report</a>
        	<a href="itemLocationReport">item location report</a>
        	<a href="itemQuantityReport">item quantity report</a>
        	</div></div></li>  
        <li><a href="viewProfile">profile</a></li>
        <li><a href="logout">logout</a></li>

      </ul><!-- navbar -->
    </div><!-- container nav-elements -->
  </nav>
  <div class="container tagline">
    <h1 class="headline">ItemTracer.com</h1>
   
  </div><!-- container tagline -->

</header>
<section class="section">
<div class="container">
    <div class="text-content">
   <p>Username: <c:out value="${sessionScope.user.userName}"></c:out> | Project: <c:out value="${sessionScope.project.projectName}"></c:out></p>
  </div>
  </div>
</section>
