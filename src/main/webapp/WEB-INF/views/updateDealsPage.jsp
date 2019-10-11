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
<h2><center>UPDATE-DEALS</center></h2><hr>
	<form:form action="updateSaveDeals" modelAttribute="deals">
		<table>

			
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
				<td><form:input path="startcity"/> <form:errors
						path="startcity" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>End City :</td>
				<td><form:input path="endcity" /> <form:errors path="endcity"
						cssStyle="color: #ff0000;" /></td>
						
						<tr>
				<td>Price :</td>
				<td><form:input path="price" /> <form:errors path="price"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			</tr>

<input type="hidden" name="dealno" value=${dealno}>

			<tr>
				<td colspan="2"><input type="submit" value="UPDATE-DEAL" /></td>
			</tr>
		</table>
	</form:form>
	
 <br><br><hr>
       <a href="transporterPage">Back</a><br>
       <a href="logout">Logout</a><br><hr>
</body>
</html>
