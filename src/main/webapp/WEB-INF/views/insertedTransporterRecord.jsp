<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

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
	<h2><center>Transporter-Record</center></h3><hr>
	<hr>
	<table border="2">
		<tr>
			<th>Email ID:</th><th>Password</th><th>Address</th>
			<th>City</th><th>State</th><th>Phone</th><th>Experience</th><th>Photo</th><th>Identity</th><th>Aadhar</th>
		</tr>
		
		<tr> 
		 	<td>${display.tusername}</td>
		 	<td>${display.passwords}</td>
		 	<td>${display.address}</td>
		 	<td>${display.city}</td>
		 	<td>${display.state}</td>
		 	<td>${display.phone}</td>
		 	<td>${display.experience}</td>
		 	
		 	<td><img width="50" height="50" src="LoadImage?tusername=${display.tusername}"/></td>
		 	<td><a href="LoadDocument?tusername=${display.tusername}">Identity Of Transporter</a></td>
		 	<td><a href="LoadDocument2?tusername=${display.tusername}">Aadhar Card Of Transporter</a></td>
		</tr>
				
	</table>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>