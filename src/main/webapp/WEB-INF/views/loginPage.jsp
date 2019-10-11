<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<html>
<body>
	<h2>
		<center>Login-Page</center>
	</h2>
	<hr>
	<form action="loginSave" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="passwords" /></td>
			</tr>
			<br>
			<tr>
				<td>Login As :</td>
				<td><font size="4" color="blue">Transporter</font><input
						type="radio" name="loginType" value="Transporter" checked="checked"/><font
						size="4" color="blue"> Customer</font><input type="radio"
						name="loginType" value="Customer" /> <font size="4" color="blue">Admin</font><input
							type="radio" name="loginType" value="Admin" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<br><br><br><hr>
	<a href="index.jsp">Home</a>
</body>
</html>
