<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h2><center>POST-A-DEAL</center></h2><hr>
	<form:form action="saveDeals" modelAttribute="deals">
		<table>

			<tr>
				<td>Vehicle ID :</td>

				<td><select name="veh">
						<c:forEach var="vehic" items="${vehiclelist}">
							<option value="${vehic.id}">${vehic.id}</option>
						</c:forEach>
				</select>
			</tr>
			
			<tr>
				<td>Start Date :</td>
				<td><input type="date" name="startdate" /></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="date" name="startdate" /></td>
			</tr>
			<tr>
				<td>Start City :</td>
				<td><form:select path="startcity" items="${citydata}"/> <form:errors
						path="startcity" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>End City :</td>
				<td><form:select path="endcity" items="${citydata}" /> <form:errors path="endcity"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /> <form:errors path="price"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			



			<tr>
				<td colspan="2"><input type="submit" value="ADD-DEAL" /></td>
			</tr>
		</table>
	</form:form>
	
	<br>
 <br><br><hr>
       <a href="transporterPage">Back</a><br>
       <a href="logout">Logout</a><br><hr>
</body>
</html>
