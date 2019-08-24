<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ItemTracer.com - Total Asset Visibility</title>
	 <link rel="stylesheet" href="css/styleLanding.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<header id="home" class="header">
  <nav class="nav" role="navigation">
    <div class="container nav-elements">
      <div class="branding">
        <p class="address">ItemTracer.com<br>
      </p>
      </div>

      <!-- branding -->
      <ul class="navbar">
        <li><a href="#home">home</a></li>
        <li><a href="#login">login</a></li>
        <li><a href="#mission">mission</a></li>
        <li><a href="#history">history</a></li>

      </ul><!-- navbar -->
    </div><!-- container nav-elements -->
  </nav>
  <div class="container tagline">
    <h1 class="headline">ItemTracer.com</h1>
    <p>Welcome to the Item Tracer Tool Suite.  Providing you with total asset visibility for every Screw to every Satellite</p>
    
  </div><!-- container tagline -->
</header><!-- #home -->

<section id="login" class="section">

  <div class="container">
  	<c:if test="${requestScope.loginError!= null}">${requestScope.loginError}</c:if>

		
    <div class="text-content">
    <div id="formContainer">
    <div id="firstForm">
    
      <h2 class="headline">Login</h2>
		
        <form action="login" method="post">
        	
			<label>Username</label> <input type="text" name="username" id="username" value="admin"><br/>
			<label>Password</label> <input type="password" name="password" id="password" value="admin"><br/>
			<input type="submit" value="Submit" id="submit">
		</form>
        <p>Log in to Item Tracer.<br /></p>
        </div>
        <div id="secondForm">
        <c:if test="${requestScope.RegisterMessage!= null}">${requestScope.RegisterMessage}</c:if>
 
		<h2 class="headline">Register</h2>
        
        
        <form action="registerUser" method="post">
			<label>Username</label> <input type="text" name="userName" id="userName"><br/>
			<label>Password</label> <input type="password" name="password" id="password"><br/>
			<label>First Name</label> <input type="text" name="firstName" id="firstName"><br/>
			<label>Last Name</label> <input type="text" name="lastName" id="lastName"><br/>
            <label>Email</label> <input type="text" name="email" id="email"><br/>
			<input type="submit" value="Submit" id="submit">
		</form>
        <p>Register as an Item Tracer user.  <br />
        You will be given access to the demo 
        and ability to start your own project.</p>
        </div>
        <div id="clearForm"></div>
		</div>
    </div>
  </div><!-- container text -->
</section><!-- #mission -->

<section id="mission" class="section">
  <div class="container">
    <div class="text-content">
      <h2 class="headline">Mission</h2>
      <p>The goal of this application is to provide traceability and visibility for all production items from stock to dock to dock to back again.</p>
      <p>This software will allow you to:</p>
      	<ol>
			<li>Log into Item Tracer.</li>
          	<li>Log into demo database.</li>
          	<li>Create new database.</li>
          	<li>Add new parts to database.</li>
          	<li>Build a parts list configuration.</li>
          	<li>Add parts to stock location.</li>
          	<li>Add new locations.</li>
          	<li>Assign parts from stock to build configurations.</li>
          	<li>Move build and assigned parts to new location.</li>
          	<li>View reports showing item location and quantity information.</li>     
      	</ol>
     

    </div>
  </div><!-- container text -->
</section><!-- #mission -->

<section id="history" class="section">
  <div class="container">
    <div class="text-content">
      <h2 class="headline">History</h2>
      <p>After spending ten years in the aerospace industry, Garet Simpson decided there had to be a better way to provide visibility for items in both the production pipeline and in the field.  </p>
      <p>His first exposure to production traceablity issues was a space level EEE parts list deliverable.  The report was a listing of the actaul part numbers and lot codes used in the delivered hardware. As simple as this sounds, none of the databases had this reporting capability. He developed processes to pull part characteristics from various sources, transform the data, and format the data for a delivery of 5000+ lists. </p>
      <p>Later in his career, he became an item manager for onsite customer owned spares. Again the database being used for the task had limited reporting capability. Garet exported the data and built an application to provide custom reporting. The tool proved to be very useful for visualizing where all items were located for  both sparing and production planning needs.</p>
      <p>The Item Tracer tool draws upon these two projects to create an applicaton with superior item traceability and visibility.</p>
    </div>
  </div><!-- container text -->
</section><!-- #history -->

<footer class="footer">
  <div class="container">
  <nav class="nav" role="navigation">
    <div class="container nav-elements">
      <div class="branding">
        <p class="address">ItemTracer.com<br>
      </p>
      </div>
    </div>
  </nav>
  <p class="legal">This website is currently for demo use.  Some features may not be fully implemented. Please use fake emails and passwords as the data may not be secure.  A lot of code was branched or inspired from Linkedin Learning course Java EE: Servlets and JavaServer Pages (JSP) by Ketkee Aryamane.</p>
</div><!-- container -->
</footer><!-- footer -->
</body>
</html>
