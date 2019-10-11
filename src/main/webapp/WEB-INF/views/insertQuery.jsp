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
<h2><center>INSERT QUERY</center></h2><hr>
	<form:form action="saveQuery">
		<table>

			<tr>
				<td>Enter Query :</td>
				<td><textarea name="queryasked"></textarea></td>
			</tr>
			
				<input type="hidden" name="tusername" value="${tusername}">
			<tr>
				<td><input type="submit" value="Submit Query"></td>

			</tr>
		</table>
	</form:form>
</body>
</html>