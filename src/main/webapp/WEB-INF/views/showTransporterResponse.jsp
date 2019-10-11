<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@page isELIgnored="false"%>

<html>
<body>
	<h2>
		<center>Customer Queries</center>
		</h2>
		<hr>
		<hr>
		<table>
			<tr>
				<th>Transporter Response</th>

			</tr>



			<c:forEach var="show" items="${list2}">

				<tr>
					<td>${show.transporterresponse}</td>

				</tr>
			</c:forEach>

		</table>
<br><br>
		<hr>
		<a href="customerPage">Home</a><br>
		<a href="logout">Logout</a>>br><hr>
</body>
</html>