<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ItemTracer.com - Total Asset Visibility</title>
	 <link rel="stylesheet" href="css/styleDashboard.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<%@include file="header.jsp" %>

<section id="mission" class="section">
  <div class="container">
    <div class="text-content">
      <h2 class="headline">Dashboard</h2>
      <p>Welcome to Item Tracer Total Asset Visibility</p>
     
	  <div class="grid">
      	 <div class="module">
      		<h3 class="headline">Projects</h3>
			<p>Change or Create Project</p>
				<ul>
          			<li><a href="changeProject">Change Project</a></li> 
					<li><a href="newProject">Create New Project</a></li> 
					<li><a href="addUserToProject">Manage Project Users</a></li> 
          		</ul>
		</div>
		<div class="module">
      		<h3 class="headline">Parts</h3>
			<p>Add new parts and assemblies</p>
          		<ul>
          			<li><a href="newPart">Add New Part</a></li> 
          			<li><a href="updatePart">Update Part</a></li>  
					<li>Add Parts to Stock Location (In Work)</li> 
					<li>Add New Assembly (In Work)</li> 
					<li>Assign Parts to Assembly (In Work)</li> 
          		</ul>
		</div>
		<div class="module">
      		<h3 class="headline">Assemblies</h3>
			<p>Add new parts and assemblies</p>
          		<ul>
          			<li><a href="">Add New Assembly (In Work)</a></li> 
          			<li><a href="">Update Assembly (In Work)</a></li> 
					<li>Add Parts to Stock Location (In Work)</li> 
					<li>Add New Assembly (In Work)</li> 
					<li>Assign Parts to Assembly (In Work)</li> 
          		</ul>
		</div>
		</div>
		<div class="module">
      		<h3 class="headline">Move Items</h3>
			<p>Move Part or Assembly to New Location</p>
          		<ul>
          			<li>Create new Location (In Work)</li>
          			<li>Assign Parts to Build (In Work)</li> 
          			<li>Change Part Location (In Work)</li> 
          		</ul>
		</div>
		<div class="module">
      		<h3 class="headline">Reports</h3>

			<p>View reports showing Part or Assembly locations</p>
          		<ul>
          			<li><a href="partHistoryReport">Part History Report</a></li> 
	          		<li><a href="stockListingReport">Stock Listing Report</a></li> 
	          		<li><a href="itemLocationReport">Item Location Report</a></li>
	          		<li><a href="itemQuantityReport">Item Quantity Report</a></li>
          		</ul>
		</div>
		<div class="module">
      		<h3 class="headline">Profile</h3>
      		<p>View Profile or Logout</p>
      		<ul>
				<li><a href="viewProfile">View Profile</a></li>
        		<li><a href="logout">Logout</a></li>
			</ul>
		</div>
		<div class="module">
      		<h3 class="headline"></h3>
      		</br></br></br>

		</div>

     
		</div><!-- grid -->
    </div>
  </div><!-- container text -->
</section><!-- #mission -->



<%@include file="footer.jsp" %>
</body>
</html>
