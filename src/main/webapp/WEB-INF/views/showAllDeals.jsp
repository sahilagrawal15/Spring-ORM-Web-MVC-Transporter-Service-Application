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
	<h2><center>Deals LIST</center></h3><hr>
	<hr>
	<table>
		<tr>
			<th>Deal No</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Start City</th>
			<th>End City</th>
			<th>Transporter Username</th>
			<th></th>
		</tr>



		<c:forEach var="show" items="${veh}">
			
			<tr>
				<td>${show.dealno}</td>
				<td>${show.startdate}</td>
				<td>${show.enddate}</td>
				<td>${show.startcity}</td>
				<td>${show.endcity}</td>
				<td>${show.transporter.tusername}</td>
			
				
				
				 <td><a href="deleteDeals?dealno=${show.getDealno()}">Remove-Deal</a></td> 
			</tr>
		</c:forEach>
		
	</table>

	<hr>
	
	<br><br><hr>
<a href="adminPage">Back</a><br>
<a href="logout">Logout</a><br><hr>
</body>
</html>