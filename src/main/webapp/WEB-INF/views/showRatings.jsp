<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@page isELIgnored="false"%>

<html>
<body>
	<h2><center>Transporter Ratings</center></h2><hr>
	<hr>
	<table>
		<tr>
		
			<th>Average Ratings</th>
			
		</tr>



		
			
			<tr>
				<td>${rating}</td>
			
	</table>

	<hr>
	
	<br><br><hr>
<a href="viewAllTransporter">Back</a><br>
<a href="adminPage">Admin-Home</a><br>
<a href="logout">Logout</a><br><hr>
</body>
</html>