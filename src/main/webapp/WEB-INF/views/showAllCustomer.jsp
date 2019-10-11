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
	<h2><center>Customer LIST</center></h3><hr>
	<hr>
	<table border="1">
		<tr>
			<th>Username</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>City</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Pincode</th>

		</tr>



		<c:forEach var="show" items="${cust}">

			<tr>
				<td>${show.getUsername()}</td>
				<td>${show.getFirstName()}</td>
				<td>${show.getMiddleName()}</td>
				<td>${show.getLastName()}</td>
				<td>${show.getCity()}</td>
				<td>${show.getGender()}</td>
				<td>${show.getMobile()}</td>
				<td>${show.getPincode()}</td>

				<%-- <td><a href="deleteController2?id=${stud.getId()}">Delete</a></td>
				<td><a href="updateController?id=${stud.getId()}">Update</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	<br>

	<hr>
	<br><br><hr>
<a href="adminPage">Back</a><br>
<a href="logout">Logout</a><br><hr>
</body>
</html>