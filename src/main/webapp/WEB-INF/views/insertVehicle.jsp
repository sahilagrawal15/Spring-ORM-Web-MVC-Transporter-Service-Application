<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <%@page isELIgnored="false" %>
  
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
  <h2><center>INSERT VEHICLE</center></h2><hr>
       <form:form action="saveVehicle" enctype="multipart/form-data" modelAttribute="vehicle">    
        <table>    
         
         <tr>
         <td>Vehicle Type : </td>
         <td><form:input path="vehicleType"/><form:errors
						path="vehicleType" cssStyle="color: #ff0000;" /></td>
         </tr>
         
          <tr>    
          <td>Model : </td>   
         <td><form:input path="model"/><form:errors
						path="model" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>Color : </td>   
         <td><form:input path="color"/><form:errors
						path="color" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>Manufacturing Year : </td>   
         <td><form:input path="manYear"/><form:errors
						path="manYear" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>Capacity : </td>   
         <td><form:input path="capacity"/><form:errors
						path="capacity" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>
         <td>Picture: </td>
         <td><input type="file" name="doc1"/></td>
         </tr>
         
         <tr>
         <td>Upload Document(As PDF): </td>
         <td><input type="file" name="doc2"/></td>
         </tr>
         
         <tr>
         <td>Upload Fitness Certificate(As PDF): </td>
         <td><input type="file" name="doc3"/></td>
         </tr>
         
         <tr>    
          <td colspan="2"><input type="submit" value="Add Vehicle" /></td>    
         </tr>    
        </table>    
       </form:form>  
       
       <br>
        <br><br><hr>
       <a href="transporterPage">Back</a><br>
       <a href="logout">Logout</a><br><hr>
       
       </body>
       </html>  
