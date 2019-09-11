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
			<h2 class="headline">Assemblies</h2>
			<p></p>
			<div class="tablecontainer">
		
				<h3 class="headline">Create New Assembly</h3>
					<br/>
				<form action="newAssembly" method="post">
					<label>Parent Part Number</label>
					<select name="parentPartNumber" id="parentPartNumber">
						<option value = "select">Select Parent Part Number</option>
							<c:forEach items="${requestScope.parts}" var="part" varStatus="loop">
								<option value = "${part.partNumber}"
								<c:if test="${requestScope.parentPart.partNumber.equals(part.partNumber) }" >selected</c:if>
								>${part.partNumber}</option>
							</c:forEach>
					</select><br/><br/>
					<label>Child Part Number</label> 
					<select name="childPartNumber" id="childPartNumber">
						<option value = "select">Select Child Part Number</option>
							<c:forEach items="${requestScope.parts}" var="part" varStatus="loop">
								<option value = "${part.partNumber}"
								<c:if test="${requestScope.childPart.partNumber.equals(part.partNumber) }" >selected</c:if>
								>${part.partNumber}</option>
							</c:forEach>
					</select><br/><br/>
					<label>Revision</label>	<input type="text" name="revision" id="revision" value="${assembly.revision}"><br/><br/>			
					<label>Item Number</label> <input type="text" name="itemNumber" id="itemNumber" value="${assembly.itemNumber}"><br/><br/>
					<label>Reference Designator</label> <input type="text" name="referenceDesignator" id="referenceDesignator"  value="${assembly.referenceDesignator}"><br/><br/>
					<label>Alternate Code</label>
					<select name="alternateCode" id="alternateCode">
						<option value = "select">Select Alternate Code</option>
							<c:forEach items="${requestScope.alternateCodes}" var="alternateCode" varStatus="loop">
								<option value = "${alternateCode.alternateCode}"
								<c:if test="${requestScope.alternateCode.equals(alternateCode.alternateCode) }" >selected</c:if>
								>${alternateCode.alternateCode}</option>
							</c:forEach>
					</select><br/><br/>
					<label>Quantity</label> <input type="text" name="quantity" id="quantity" value="${assembly.quantity}"><br/><br/>
					<input type="submit" value="Submit" id="submit">
				</form>
				
				<p><c:if test="${requestScope.newAssemblyMessage!= null}">${requestScope.newAssemblyMessage}</c:if></p>
				<c:if test="${requestScope.newAssembly!= null}">
				<br/>
					<table >
							<tr>
								<th>Id</th>
								<th>Project</th>
								<th>Parent Part Number</th>
								<th>Child Part Number</th>
								<th>Revision</th>
								<th>Item Number</th>
								<th>Reference Designator</th>
								<th>Alternate Code</th>
								<th>Quantity</th>
								<th>Creation Date</th>
								<th>Author</th>
								
							</tr>
								<tr>
									<td>${requestScope.newAssembly.assemblyId}</td>
									<td>${requestScope.newAssembly.projectName}</td>
									<td>${requestScope.newAssembly.parentPartNumber}</td>
									<td>${requestScope.newAssembly.childPartNumber}</td>
									<td>${requestScope.newAssembly.revision}</td>
									<td>${requestScope.newAssembly.itemNumber}</td>
									<td>${requestScope.newAssembly.referenceDesignator}</td>
									<td>${requestScope.newAssembly.alternateCode}</td>
									<td>${requestScope.newAssembly.quantity}</td>
									<td>${requestScope.newAssembly.timeStamp}</td>
									<td>${requestScope.newAssembly.authorUserName}</td>
									
								</tr>
						</table>
				</c:if>
				<p></p>
				<br/>
				<ul>
					<li><a href="">Add New Assembly</a></li> 
          			<li><a href="">View Assembly</a></li> 	
          		</ul>

			</div>
		</div>
	  </div>
	</section>
    

<%@include file="footer.jsp" %>
</body>
</html>




