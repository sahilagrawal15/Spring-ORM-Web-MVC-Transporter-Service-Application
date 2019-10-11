<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
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
	<h2><center>Customer Queries</center></h3><hr>
	<hr>
	<table>
		<tr>
			<th>Customer Question</th>
			
		</tr>



		<c:forEach var="show" items="${transporterlist}">
			
			<tr>
				<td>${show.customerrequest}</td>
				
				
				
				 <td><a href="respondToQuery?qid=${show.qid}">Respond to this Query?</a></td>
<%-- 				 <td><a href="respondToQuery2?qid=${show.qid}&&username=${show.customerrequest}">Respond to this Query?</a></td> 
 --%>				
			</tr>
		</c:forEach>
		
	</table>

	<hr>
	
	<a href="transporterPage">Back</a><br>
		<a href="index.jsp">Home-Page</a><br><hr>
	
</body>
</html>