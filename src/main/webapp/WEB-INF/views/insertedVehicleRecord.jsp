
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

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

<table border="2">
	<tr>
		
		<th>Vehicle Type</th>
		<th>Model</th>
		<th>Color</th>
		<!-- <th>DOB</th> -->
		<th>Manufacturing Year</th>
		<th>Capacity</th>
		<th>Picture</th>
		<th>Documents</th>
		<th>Fitness Certificate</th>
	</tr>
	
		<tr>
			<td>${display1.vehicleType}</td>
			<td>${display1.model}</td>
			<td>${display1.color}</td>
			<%-- <td>${cust.dob}</td> --%>
			<td>${display1.manYear}</td>
			<td>${display1.capacity}</td>
			<td><img width="50" height="50" src="LoadImages?id=${display1.id}"/></td>
		 	<td><a href="LoadDocuments?id=${display1.id}">Documents</a></td>
		 	<td><a href="LoadDocuments2?id=${display1.id}">Fitness Certificate</a></td>
		</tr>
	
</table>

 <br><br><hr>
       <a href="transporterPage">Home</a><br>
       <a href="logout">Logout</a><br><hr>
       
       </html>

