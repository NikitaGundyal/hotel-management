<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${user.firstname} to the hotel booking
<div style="float: right;">
<h1>${user.firstname}</h1>
<a href="${pageContext.request.contextPath}">Logout</a>
</div>
<br>
<br>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br><br>
<h1>Edit The Room Details</h1>
 <form:form action="/editRooms.htm" method="post" commandName="room" enctype="multipart/form-data" >
             <form:input type="hidden"  path="id" />
             <label> Room Number:</label>
             <form:input path="roomNumber" name="roomNumber" type="text"/><br><br>
             
              <label>Room Type:</label>
              <select name="roomTypes">
				  <option value="single">Single</option>
				  <option value="double">Double</option>
				  <option value="executive">Executive</option>
				  <option value="suite">Suite</option>
			  </select>    <br><br>   
			  
				<label>Total Rooms:</label>
				<div>
					<select name="totalrooms">
						<c:forEach begin="1" end="20" var="data">
							<option value="${data}">${data}</option>
						</c:forEach>
					</select>
				</div>
			</div> 
            
             
              <label>Room Description:</label>
             <form:input path="roomDesc" name="roomDesc" type="textarea" /><br><br>
             
            <label>Upload Room Photo:</label>      
            <input type="file" name="roomPhoto"  required="required"/><br><br>
        
             <input type="submit" value="Add Edited Room" />
         
  </form:form>


</body>
</html>