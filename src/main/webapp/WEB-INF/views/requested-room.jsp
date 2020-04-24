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
<style>
<style>

table,  td {
  border: 1px solid black;
   border-collapse: collapse;
}
 table.center {
    margin-left:auto; 
    margin-right:auto;
  }



</style>
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
					<li class="active"><a href="${contextPath}/guest/roomBookRequest.htm">Book a room</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/guest/viewRoomBookRequest.htm">View Room Book request</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${contextPath}">Logout</a></li>
				</ul>				
		   </div>
     </div>
</nav>

<%-- Welcome ${user.firstname} to the hotel booking
<div style="float: right;">
<h1>${user.firstname}</h1>
<a href="${pageContext.request.contextPath}">Logout</a>
</div>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br> --%>


<p>${requestedRoom.roomNumber} ${requestedRoom.roomType}</p>
	<br>
	<p>${requestNumber.bookingID}</p>


	<div class="container">
	<h2> Booked Room details</h2>
		<table class="center">
			<tr>
				<td><b>ID</b></td>
				<td><b>Room Number</b></td>
				<td><b>Room Type</b></td>
				<td><b>Room Desc</b></td>
				<td><b>Room Price</b></td>
				<td><b>Check-In Date</b></td>
				<td><b>Check-Out Date</b>
				<td><b>No of Days</b></td>
				<td><b>Status</b></td>
				<td><b>Email the details</b></td>
			</tr>
			<c:forEach var="bl" items="${bookingsList}">
				<tr>
					<td>${bl.bookingID}</td>
					<td>${bl.room.roomNumber}</td>
					<td>${bl.room.roomType}</td>
					<td>${bl.room.roomDesc}</td>
					<td>${bl.room.roomPrice}</td>
					<td>${bl.checkIn}</td>
					<td>${bl.checkOut}</td>
					<td>${bl.numOfDays}</td>
					<td>${bl.roomStatus}</td>
					<td>Emailed the details</td>
				</tr>
			</c:forEach>
		</table>


	</div>

</body>
</html>