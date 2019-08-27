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
			<h2 class="headline">Parts</h2>
			<p></p>
			<div class="tablecontainer">
		
				<h3 class="headline">Create New Part</h3>
					<br/>
				     <form action="newPart" method="post">
					<label>Part Number</label> <input type="text" name="newPartNumber" id="newPartNumber" value="${part.partNumber}"><br/><br/>
					<label>Drawing Number</label> <input type="text" name="newDrawingNumber" id="newDrawingNumber" value="${part.drawingNumber}"><br/><br/>
					<label>Part Type</label>
					<select name="newPartTypeName" id="newPartTypeName" >
						<option value = "select">Select Part Type</option>
							<c:forEach items="${requestScope.partTypes}" var="partType" varStatus="loop">
								<option value = "${partType.partType}"
								<c:if test="${requestScope.partType.partType.equals(partType.partType) }" >selected</c:if>
								>${partType.partType}</option>
							</c:forEach>
					</select><br/><br/>
					
					<label>Part Description</label> <input type="text" name="newPartDescription" id="newPartDescription" value="${part.partDescription}"><br/><br/>
					<label>Cage Code</label> <input type="text" name="newCageCode" id="newCageCode"  value="${part.cageCode}"><br/><br/>
					<label>Manufacturer</label> <input type="text" name="newManufacturer" id="newManufacturer" value="${part.manufacturer}"><br/><br/>
					<input type="submit" value="Submit" id="submit">
				</form>
				
				<p><c:if test="${requestScope.newPartMessage!= null}">${requestScope.newPartMessage}</c:if></p>
				<c:if test="${requestScope.newPart!= null}">
				<br/>
					<table >
							<tr>
								<th>Part Id</th>
								<th>Part Project</th>
								<th>Part Number</th>
								<th>Drawing Number</th>
								<th>Part Type</th>
								<th>Part Description</th>
								<th>Cage Code</th>
								<th>Manufacturer</th>
								<th>Creation Date</th>
								<th>Author</th>
								
							</tr>
								<tr>
									<td>${requestScope.newPart.partId}</td>
									<td>${requestScope.newPart.projectName}</td>
									<td>${requestScope.newPart.partNumber}</td>
									<td>${requestScope.newPart.drawingNumber}</td>
									<td>${requestScope.newPart.partTypeName}</td>
									<td>${requestScope.newPart.partDescription}</td>
									<td>${requestScope.newPart.cageCode}</td>
									<td>${requestScope.newPart.manufacturer}</td>
									<td>${requestScope.newPart.timeStamp}</td>
									<td>${requestScope.newPart.authorUserName}</td>
									
								</tr>
						</table>
				</c:if>
				<p></p>
				<br/>
				<ul>
					<li><a href="newPart">Add New Part</a></li> 
          			<li><a href="updatePart">Update Part</a></li> 	
          		</ul>

			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




