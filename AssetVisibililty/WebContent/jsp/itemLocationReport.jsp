<!DOCTYPE html>
<%@ page import = "com.itemtracer.beans.ItemMovementBean"%>
<%@page import="java.util.Iterator"%>
<%@ page import = "java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
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
      <h2 class="headline">Item Location Report</h2>
      <p>This report shows all the locations for selected part description.</p>
      	<form action="itemLocationReport" method="post">
			<label>Part Description</label> 
			<select name="partDescription" id = "partDescription" onchange="this.form.submit()">
				<option value = "select">Select Part</option>
					<c:forEach items="${requestScope.PartDescriptions}" var="partDescriptions" varStatus="loop">
						<option value = "${partDescriptions.partDescription}"
							<c:if test="${requestScope.PartDescription.equals(partDescriptions.partDescription) }" >selected</c:if>
							>${partDescriptions.partDescription}</option>
					</c:forEach>
			</select><br/><br/>
		</form><br/>
    </div>
    <div class="tablecontainer">
    	<c:if test="${requestScope.LocationMap!=null }">
    		
			<c:forEach items="${requestScope.LocationMap.keySet()}" var="location" varStatus="loop">	
		  	<table ><caption>${location}</caption>
			<tr>
				<th>Time Stamp</th>
				<th>Project Name</th>
				<th>Movement Type</th>
				<th>Part Description</th>
				<th>Part Number</th>
				<th>Serial Number</th>
				<th>Quantity</th>
				<th>Parent Part Number</th>
				<th>Parent Serial Number</th>
				<th>Origin</th>
				<th>Destination</th>
				<th>Part Status</th>
				<th>Owner Name</th>
				<th>Notes</th>
				<th>Attachments</th>
				<th>Author</th>
			</tr>	
		  			
	
			<c:forEach items="${requestScope.LocationMap.get(location)}" var="itemMovement" varStatus="loop">
			<tr>
				<td>${itemMovement.timeStamp}</td>
				<td>${itemMovement.projectName}</td>
				<td>${itemMovement.movementType}</td>
				<td>${itemMovement.partDescription}</td>
				<td>${itemMovement.partNumber}</td>
				<td>${itemMovement.serialNumber}</td>
				<td>${itemMovement.quantityAssigned}</td>
				<td>${itemMovement.parentPartNumber}</td>
				<td>${itemMovement.parentSerialNumber}</td>
				<td>${itemMovement.originLocationName}</td>
				<td>${itemMovement.destinationLocationName}</td>
				<td>${itemMovement.statusType}</td>
				<td>${itemMovement.ownerName}</td>
				<td>${itemMovement.note}</td>
				<td>${itemMovement.attachment}</td>
				<td>${itemMovement.authorUser}</td>
			</tr>
			</c:forEach>
		
		  	</table>
		  	<br/><br/><br/>
		</c:forEach>	
	
		  	
	</c:if>
</div>
  </div><!-- container text -->
  
</section><!-- #mission -->
<br/><br/><br/>

<%@include file="footer.jsp" %>
</body>
</html>
