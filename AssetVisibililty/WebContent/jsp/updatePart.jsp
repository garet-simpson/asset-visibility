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
		
				<h3 class="headline">Update Part</h3>
					<br/>
				     <form action="updatePart" method="post">
					<label>Part Number</label>
					<select name="partNumber" id="partNumber" onchange="this.form.submit()">
						<option value = "select">Select Part Number</option>
							<c:forEach items="${requestScope.parts}" var="part" varStatus="loop">
								<option value = "${part.partNumber}"
								<c:if test="${requestScope.part.partNumber.equals(part.partNumber) }" >selected</c:if>
								>${part.partNumber}</option>
							</c:forEach>
					</select>
					<br/><br/>
					<c:if test="${requestScope.part!=Null}">
					<label>Drawing Number</label> <input type="text" name="drawingNumber" id="drawingNumber" value="${part.drawingNumber}"><br/><br/>
					<label>Part Type</label>
					<select name="partTypeName" id="partTypeName">
						<option value = "select">Select Part Type</option>
							<c:forEach items="${requestScope.partTypes}" var="partType" varStatus="loop">
								<option value = "${partType.partType}"
								<c:if test="${requestScope.partType.partType.equals(partType.partType) }" >selected</c:if>
								>${partType.partType}</option>
							</c:forEach>
					</select><br/><br/>
					
					<label>Part Description</label> <input type="text" name="partDescription" id="partDescription" value="${part.partDescription}"><br/><br/>
					<label>Cage Code</label> <input type="text" name="cageCode" id="cageCode" value="${part.cageCode}"><br/><br/>
					<label>Manufacturer</label> <input type="text" name="manufacturer" id="manufacturer" value="${part.manufacturer}"><br/><br/>
					<input type="submit" value="Update" id="update" name="update" >
					<input type="submit" value="Save As" id="saveAs" name="saveAs" >
					<input type="submit" value="Delete" id="delete" name="delete" onclick="return ConfirmDelete();">

					</c:if>
					</form>
						<br/>
						<p><c:if test="${requestScope.updatePartMessage!= null}">${requestScope.updatePartMessage}</c:if></p>
						<c:if test="${requestScope.updatePart!= null}">
						
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
											<td>${requestScope.part.partId}</td>
											<td>${requestScope.part.projectName}</td>
											<td>${requestScope.part.partNumber}</td>
											<td>${requestScope.part.drawingNumber}</td>
											<td>${requestScope.part.partTypeName}</td>
											<td>${requestScope.part.partDescription}</td>
											<td>${requestScope.part.cageCode}</td>
											<td>${requestScope.part.manufacturer}</td>
											<td>${requestScope.part.timeStamp}</td>
											<td>${requestScope.part.authorUserName}</td>
											
										</tr>
								</table>

						</c:if>
					
				<p></p>
				<br/><br/><br/>
				<ul>
          			<li><a href="newPart">Add New Part</a></li> 	
          		</ul>

			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>

	<script>
			function ConfirmDelete() {
				var x = confirm("Are you sure you want to delete?");
			    if (x)
			    	return true;
			    else
			        return false;
			}
	</script>
</html>




