<%@page isELIgnored="false" %>

<html>
<body>

	<h2><center>Record Found</center></h2><hr>
	<form><pre>
	Username   :    ${transporter.tusername}
	Address   :     ${transporter.address}
	City   :        ${transporter.city}
	State   :       ${transporter.state}
	Phone    :      ${transporter.phone}
	Experience   :  ${transporter.experience}
	
	
	
	</pre>
	
	<img width="50" height="50" src="LoadImage?tusername=${transporter.tusername}"/>
		 	<a href="LoadDocument?tusername=${transporter.tusername}">Identity Of Transporter</a>
		 	<a href="LoadDocument2?tusername=${transporter.tusername}">Aadhar Card Of Transporter</a>
	</form><hr>
	
	
	<a href="adminPage">Admin-Home</a><br>
	<a href="index.jsp">Home</a><br>
	<a href="logout">Logout</a><br><hr>
</body>
</html>