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
<h2><center>RESPOND TO CUSTOMER QUERIES</center></h2><hr>
	<form:form action="saveTrasnsporterResponse">
		<table>

			<tr>
				<td>Enter Response :</td>
				<td><textarea name="responseGiven"></textarea></td>
			</tr>
			
				<input type="hidden" name="username" value="${username}">
			<tr>
				<td><input type="submit" value="Submit Response"></td>

			</tr>
		</table>
	</form:form>
	
	 <br><br><hr>
       <a href="transporterPage">Home</a><br>
       <a href="logout">Logout</a><br><hr>
</body>
</html>