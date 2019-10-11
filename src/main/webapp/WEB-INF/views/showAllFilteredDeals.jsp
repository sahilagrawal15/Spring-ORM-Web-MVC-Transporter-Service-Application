<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>DEALS PAGE</h2>

<form action="filterDeals">
Start City:
<select name="startcity">
<c:forEach var="cit" items="${citylist}">
<option value="${cit}">${cit}</option>
</c:forEach>
</select>

End City:
<select name="endcity">
<c:forEach var="cit" items="${citylist}">
<option value="${cit}">${cit}</option>
</c:forEach>
</select>

Date : <input type="date" name="startdate"><br>
Order By:
<input type="checkbox" name="price" value="price">Price

<input type="submit" value="Submit">
</form>
<br>

<table>
<tr>
<th>ID</th>
<th>Start City</th>
<th>End City</th>
<th>Start Date</th>
<th>End Date</th>
</tr>

<c:forEach var="deal" items="${list}">
<td>${deal.id}</td>
<td>${deal.startcity}</td>
<td>${deal.endcity}</td>
<td>${deal.startdate}</td>
<td>${deal.enddate}</td>
</c:forEach>



</table>




</form>
</body>
</html>