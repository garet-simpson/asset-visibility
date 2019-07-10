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
      <h2 class="headline">reports</h2>
      <p>Welcome to Item Tracer Total Asset Visibility</p>
		<p>View Reports below:</p>
      	<ol>
      		<li><a href="partHistoryReport">Part History Report</a>
			<li><a href="stockListingReport">Stock Listing Report</a></li> 
            <li><a href="itemLocationReport">Item Location Report</a></li>   		
            <li><a href="itemQuantityReport">Item Quantity Report</a></li>   		    
      	</ol>
     

    </div>
  </div><!-- container text -->
</section><!-- #mission -->


<%@include file="footer.jsp" %>
</body>
</html>
