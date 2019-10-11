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
	<h2><center>Transporter LIST</center></h3><hr>
	<hr>
	<table>
		<tr>
			<th>Username</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Phone</th>
			<th>Experience</th>
			<th>Status</th>
			
		</tr>



		<c:forEach var="show" items="${trans}">
			
			<tr>
				<td>${show.getTusername()}</td>
				<td>${show.getAddress()}</td>
				<td>${show.getCity()}</td>
				<td>${show.getState()}</td>
				<td>${show.getPhone()}</td>
				<td>${show.getExperience()}</td>
				<td>${show.getApproval()}</td>
				
				 <td><a href="approveTransporter?code=${show.getTusername()}">Approve</a>
				 <a href="deleteTransporter?tusername=${show.getTusername()}">Delete-Transporter</a>
				 <a href="showAvgRatings?tusername=${show.getTusername()}">Show Average Ratings</a></td>
				 
			
			</tr>
		</c:forEach>
		
	</table>

	<hr>
	
	<br><br><hr>
<a href="adminPage">Back</a><br>
<a href="logout">Logout</a><br><hr>
</body>
</html>