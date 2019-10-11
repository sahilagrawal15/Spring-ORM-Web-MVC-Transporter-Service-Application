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
	<h2><center>Vehicle LIST</center></h2><hr>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>Vehicle Type</th>
			<th>Model</th>
			<th>Color</th>
			<th>Manufacturing Year</th>
			<th>Capacity</th>
			<th>ApproveStatus</th>
			<th>Transporter</th>
		</tr>



		<c:forEach var="show" items="${veh}">
			
			<tr>
				<td>${show.id}</td>
				<td>${show.getVehicleType()}</td>
				<td>${show.getModel()}</td>
				<td>${show.getColor()}</td>
				<td>${show.getManYear()}</td>
				<td>${show.getCapacity()}</td>
				<td>${show.isApproval()}</td>
				<td>${show.transporter.tusername}</td>
				
				
				<td><a href="deleteVehicle?id=${show.getId()}">Delete-Vehicle</a></td>
				<td><a href="approveVehicle?id1=${show.getId()}">Approve-Vehicle</a></td>
			</tr>
		</c:forEach>
		
	</table>

	<hr>
	
<br><br><hr>
<a href="adminPage">Back</a><br>
<a href="logout">Logout</a><br><hr></body>
</html>