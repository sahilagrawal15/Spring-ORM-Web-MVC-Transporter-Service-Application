
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
<body>

<h2>INSERTED CUSTOMER RECORD</h2>

<table border="2">
	<tr>
		<th>Email</th>
		<th>First Name</th>
		<th>Middle Name</th>
		<th>Last Name</th>
		<!-- <th>DOB</th> -->
		<th>City</th>
		<th>Gender</th>
		<th>Age</th>
		<th>Pincode</th>
		<th>Occupation</th>
	</tr>
	
		<tr>
			<td>${display.username}</td>
			<td>${display.firstName}</td>
			<td>${display.middleName}</td>
			<td>${display.lastName}</td>
			<%-- <td>${cust.dob}</td> --%>
			<td>${display.city}</td>
			<td>${display.gender}</td>
			<td>${display.mobile}</td>
			<td>${display.pincode}</td>
			<td>${display.confirmPassword}
		</tr>
	
</table><hr>
</body>
<br><br>
<a href="index.jsp">Home</a>
<hr>

</html>