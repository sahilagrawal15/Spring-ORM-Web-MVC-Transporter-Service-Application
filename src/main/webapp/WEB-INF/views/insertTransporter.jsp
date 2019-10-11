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
  <h2><center>INSERT TRANSPORTER</center></h2><hr>
       <form:form action="saveTransporter" enctype="multipart/form-data" modelAttribute="transporter">    
        <table>    
         <tr>    
          <td>Email ID : </td>   
         <td><form:input path="tusername"/> <form:errors
						path="tusername" cssStyle="color: #ff0000;" /></td> 
         </tr>    
         
         <tr>
         <td>Password : </td>
         <td><input type="password" name="passwords"/> <form:errors
						path="passwords" cssStyle="color: #ff0000;" /></td>
         </tr>
         
          <tr>    
          <td>Address : </td>   
         <td><form:input path="address"/> <form:errors
						path="address" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>City : </td>   
         <td><form:select path="city" items="${citydata}"/></td> 
         </tr>  
         
          <tr>    
          <td>State : </td>   
         <td><form:input path="state"/> <form:errors
						path="state" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>Phone Number : </td>   
         <td><form:input path="phone"/> <form:errors
						path="phone" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         
          <tr>    
          <td>Experience(in years) : </td>   
         <td><form:input path="experience"/> <form:errors
						path="experience" cssStyle="color: #ff0000;" /></td> 
         </tr>  
         <tr>
         <td>Upload Image: </td>
         <td><input type="file" name="photo1"/></td>
         </tr>
         
         <tr>
         <td>Upload Document(As PDF): </td>
         <td><input type="file" name="photo2"/></td>
         </tr>
         
         <tr>
         <td>Upload Aadhar Card(As PDF): </td>
         <td><input type="file" name="photo3"/></td>
         </tr>
         
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
       
       </body>
       
       <br><br><br><hr>
<a href="index.jsp">Home</a><hr>
       </html>  
