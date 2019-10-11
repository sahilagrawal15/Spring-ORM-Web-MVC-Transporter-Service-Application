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
<h2><center>UPDATE CUSTOMER RECORD</center></h2><hr>
	<form:form action="updateSaveCustomer" modelAttribute="customer">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="username" /> <form:errors path="username"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Middle Name :</td>
				<td><form:input path="middleName" /> <form:errors
						path="middleName" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /> <form:errors path="lastName"
						cssStyle="color: #ff0000;" /></td>
			</tr>

			<%-- <tr>    
          <td>Date :</td>    
          <td><form:input path="date"/> <form:errors path="date" cssStyle="color: #ff0000;"/></td>  
         </tr> --%>
			<tr>
				<td>City :</td>

				<td><form:select path="city" items="${citydata}" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /></td>
				<form:errors path="gender" cssStyle="color: #ff0000;" />
				</td>
			</tr>

			<tr>
				<td>Age :</td>
				<td><form:input path="mobile" /> <form:errors path="mobile"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Pincode :</td>
				<td><form:input path="pincode" /> <form:errors path="pincode"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="passwords" /> <form:errors
						path="passwords" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Occupation :</td>
				<td><form:input path="confirmPassword" /> <form:errors
						path="confirmPassword" cssStyle="color: #ff0000;" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
<br><hr>
<a href="customerPage">Back</a><br>
<a href="logout">Logout</a><hr>
</body>
</html>
