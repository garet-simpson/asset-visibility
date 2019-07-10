<!DOCTYPE html>
<%@ page import = "com.itemtracer.beans.ItemMovementBean"%>
<%@page import="java.util.Iterator"%>
<%@ page import = "java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ItemTracer.com - Total Asset Visibility</title>
	 <link rel="stylesheet" href="css/styleReport.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<%-- <%@include file="header.jsp" %> --%> 
<jsp:include page="header.jsp"></jsp:include>

<section id="mission" class="section">
  <div class="container">
    <div class="text-content">
      <h2 class="headline">Part History Report</h2>
      <p>This report shows all transactions for a given Part Description and Serial Number combination</p>
      	<form action="partHistoryReport" method="post">
			<label>Part Description</label> 
			<select name="partDescription" id = "partDescription" onchange="this.form.submit()">
				<option value = "select">Select Part</option>
					<c:forEach items="${requestScope.PartDescriptions}" var="partDescriptions" varStatus="loop">
						<option value = "${partDescriptions.partDescription}"
							<c:if test="${requestScope.PartDescription.equals(partDescriptions.partDescription) }" >selected</c:if>
							>${partDescriptions.partDescription}</option>
					</c:forEach>
			</select><br/><br/>
		<label>Serial Number</label> 
			<select name="serialNumber" id = "serialNumber" onchange="this.form.submit()">
				<option value = "select">Select SN</option>
				<c:if test="${requestScope.SerialNumbers!=null }">
					<c:forEach items="${requestScope.SerialNumbers}" var="serialNumbers" varStatus="loop">
						<option value = "${serialNumbers.serialNumber}"
							<c:if test= "${requestScope.SerialNumber.equals(serialNumbers.serialNumber) }" >selected</c:if>
							>${serialNumbers.serialNumber}</option>
					</c:forEach>
				</c:if>
			</select><br/>
		</form><br/>
    </div>
    <c:if test="${requestScope.ItemMovements!=null }">
	    <div class="tablecontainer">
		<table >
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
			
			<c:forEach items="${requestScope.ItemMovements}" var="itemMovement" varStatus="loop">
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
</div>
	</c:if>
  </div><!-- container text -->
  
</section><!-- #mission -->
<br/><br/><br/>

<%@include file="footer.jsp" %>
</body>
</html>
