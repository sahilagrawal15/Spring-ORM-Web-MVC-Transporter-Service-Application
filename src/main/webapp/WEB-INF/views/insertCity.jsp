<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ADD-CITY</h2>

<form:form action="saveCity" modelAttribute="city">
Enter City name:

<form:input path="cityname"/>
<input type="submit" value="Submit">




</form:form>

<c:forEach var="item" items="${citylist}">${item}
</c:forEach>

<br><br><hr>
<a href="adminPage">Back</a><br>
<a href="logout">Logout</a><br><hr>
</body>
</html>