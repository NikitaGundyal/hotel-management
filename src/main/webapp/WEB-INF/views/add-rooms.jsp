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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<div class="jumbotron" id="mainFrame">
		 <div id="textcenter">
		   <h1 class="display-4">Hotel Booking!!</h1>
		  <p class="lead">Welcome ${user.firstname} to Hyatt Hotel</p>
		 </div>  
		</div>

<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/home">Home</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/admin/addRooms.htm">Add Rooms</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/admin/viewGuests.htm">View Guests</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/admin/viewAllRooms.htm">View All Rooms</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/admin/viewGuestsBookedRooms.htm">View Guest Booked Rooms</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${contextPath}">Logout</a></li>
				</ul>				
		   </div>
     </div>
</nav>

	<div class="container">
		<form:form action="addRooms.htm" method="post" commandName="room"
			enctype="multipart/form-data" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Room Number:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="roomNumber"
						placeholder="Enter room number" required="true" />
					<font color="blue"><form:errors path="roomNumber"></form:errors></font>
				</div>
			</div>
			  <label>Room Type:</label>
              <select name="roomTypes">
				  <option value="single">Single</option>
				  <option value="double">Double</option>
				  <option value="executive">Executive</option>
				  <option value="suite">Suite</option>
			  </select> <form:errors path="roomType"/> 
			
			<div class="form-group">
				<label class="control-label col-sm-2">Room Description:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="roomDesc"
						placeholder="Enter Room Description"  required="true"/>
					<font color="red"><form:errors path="roomDesc"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Total Room:</label>
				<div class="col-sm-10">
					<select name="totalrooms" class="form-control">
						<c:forEach begin="1" end="1" var="data">
							<option value="${data}">${data}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Upload Room Photo:</label>
				<div class="col-sm-10">
					<input type="file" name="roomPhoto" class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-secondary btn-lg" value="Add Room" />
				</div>
			</div>
		</form:form>
	</div>
		  
		  
<%-- Welcome ${user.firstname} to the hotel booking
<div style="float: right;">
<h1>${user.firstname}</h1>
<a href="${pageContext.request.contextPath}">Logout</a>
</div>
<br>
<br>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br><br> --%>
<%-- <h1>Add Rooms</h1>

        <form:form action="addRooms.htm" method="post" commandName="room" enctype="multipart/form-data" >
      
             <label> Room Number:</label>
             <form:input path="roomNumber" name="roomNumber" type="text" /><form:errors path="roomNumber"/><br><br>
             
              <label>Room Type:</label>
              <select name="roomTypes">
				  <option value="single">Single</option>
				  <option value="double">Double</option>
				  <option value="executive">Executive</option>
				  <option value="suite">Suite</option>
			  </select> <form:errors path="roomType"/>   <br><br>   
			  
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
             <form:input path="roomDesc" name="roomDesc" type="textarea"  /><form:errors path="roomDesc"/><br><br>
             
            <label>Upload Room Photo:</label>      
            <input type="file" name="roomPhoto"  required="required"/><br><br>
        
             <input type="submit" value="Add Room" />
         
  </form:form>
 --%>
</body>
</html>