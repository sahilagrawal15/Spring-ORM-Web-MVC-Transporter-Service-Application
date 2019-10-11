<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@page isELIgnored="false"%>

<html>

<head>
<style>

h2{
	
  border: 1px solid black;
  align-content: center;

}
table {
	border-collapse: collapse;
	width: 65%;
	cellpadding: "9";
	cellspacing: "9";
	border-color: coral;
	
	
}

th, td {
	padding: 12px;
	text-align: left;
	  font-style: oblique;
	
}
</style>
</head>


<body>
	<h2><center>My Vehicle LIST</center></h2><hr>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>Vehicle Type</th>
			<th>Model</th>
			<th>Color</th>
			<th>Manufacturing Year</th>
			<th>Capacity</th>
			<th>Image</th>
			<th>Document</th>
			<th>Fitness Certificate</th>
		</tr>



		<c:forEach var="show" items="${myvehiclelist}">
			
			<tr>
				<td>${show.id}</td>
				<td>${show.getVehicleType()}</td>
				<td>${show.getModel()}</td>
				<td>${show.getColor()}</td>
				<td>${show.getManYear()}</td>
				<td>${show.getCapacity()}</td>
				<td><img width="50" height="50" src="LoadImages?id=${show.id}"/></td>
		 	<td><a href="LoadDocuments?id=${show.id}">Documents</a></td>
		 	<td><a href="LoadDocuments2?id=${show.id}">Fitness Certificate</a></td>
				
				
				<td><a href="deleteVehicle2?id=${show.getId()}">Un-register</a></td>
			</tr>
		</c:forEach>
		
	</table>

	<hr>
	
<br><br><hr>
<a href="transporterPage">Back</a><br>
<a href="logout">Logout</a><br><hr></body>
</html>