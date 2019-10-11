
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<h2>DEAL POSTED</h2><hr><br><br>
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
		
		<th>Deal No</th>
		<th>Start Date</th>
		<th>End Date</th>
		<th>Start City</th>
		<!-- <th>DOB</th> -->
		<th>End City</th>
		<th>Transporter Username</th>
		<th>Price</th>
	</tr>
	
		<tr>
			
			<td>${display.dealno}</td>
			<td>${display.startdate}</td>
			<td>${display.enddate}</td>
			<td>${display.startcity}</td>
			<%-- <td>${cust.dob}</td> --%>
			<td>${display.endcity}</td>
			<td>${display.transporter.tusername}</td>
			<td>${display.price}</td>
			
		</tr>
	
</table>

</html>

 <br><br><hr>
       <a href="transporterPage">Home</a><br>
       <a href="logout">Logout</a><br><hr>
