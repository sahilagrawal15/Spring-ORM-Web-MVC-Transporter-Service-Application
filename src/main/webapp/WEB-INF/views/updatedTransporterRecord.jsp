<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>
<body>

<h2>Transporter Record Updated</h2>
<%-- <head>
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
	<h2><center>Transporter-Updated-Record</center></h3><hr>
	<hr>
	<table border="2">
		<tr>
			<th>Email ID</th><th>Password</th><th>Address</th>
			<th>City</th><th>State</th><th>Phone</th><th>Experience</th>
		</tr>
		
		<tr> 
		 	<td>${tusername}</td>
		 	<td>${passwords}</td>
		 	<td>${address}</td>
		 	<td>${city}</td>
		 	<td>${state}</td>
		 	<td>${phone}</td>
		 	<td>${experience}</td>
		 	
		 	<td><img width="50" height="50" src="LoadImage?tusername=${tusername}"/></td>
		 	<td><a href="LoadDocument?tusername=${tusername}">Identity Of Transporter</a></td>
		 	<td><a href="LoadDocument2?tusername=${tusername}">Aadhar Card Of Transporter</a></td>
		</tr>
				
	</table>
	<hr><br><br><hr>
	 --%>
</body>
<a href="transporterPage">Home</a><br>
	<a href="logout">Logout</a><hr>
</html>