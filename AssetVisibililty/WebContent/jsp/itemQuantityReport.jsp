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
      <h2 class="headline">Item Quantity Report</h2>
      <p>This report displays the quantities for each part description.</p>
      	
    </div>
    <div class="tablecontainer">
   		  	<table >
				<tr>
					<th>Part Description</th>
					<th>Quantity</th>
				</tr>
					<c:forEach items="${requestScope.PartDescriptionCounter.keySet()}" var="partDescription">
						<tr>
							<td>${partDescription}</td>
							<td>${requestScope.PartDescriptionCounter.get(partDescription)}</td>
						</tr>
					</c:forEach>
	
		  	</table>
	<br/><br/><br/>

	</div>
	
	    <div class="tablecontainer">
   		  	<table >
				<tr>
					<th>Part Description</th>
					<th>Part Number</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${requestScope.PartNumberCounter.keySet()}" var="itemMovement">

					<tr>
						<td>${itemMovement.partDescription}</td>
						<td>${itemMovement.partNumber}</td>
						<td>${requestScope.PartNumberCounter.get(itemMovement)}</td>
					</tr>
	
				</c:forEach>
		  	</table>
	<br/><br/><br/>

	</div>
  </div><!-- container text -->
  
</section><!-- #mission -->
<br/><br/><br/>

<%@include file="footer.jsp" %>
</body>
</html>
