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
<h2><center>GIVE RATINGS</center></h2><hr>
	<form:form action="saveRatings">
		<table>

			<tr>
				<td>Select Rating :</td>
				<td>
				<select name="ratingpoints">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				
				
				
				</select>
				</td>
				 
			</tr>
			
				<input type="hidden" name="tusername" value="${tusername}">
				<input type="hidden" name="dealcode" value="${dealcode}">
				<input type="hidden" name="customers" value="${customers}">
				
			<tr>
				<td><input type="submit" value="Submit Ratings"></td>

			</tr>
		</table>
	</form:form>
	
	<br><br><hr>
	<a href="customerPage">Home</a><br>
	<a href="logout">Logout</a><hr>
</body>
</html>