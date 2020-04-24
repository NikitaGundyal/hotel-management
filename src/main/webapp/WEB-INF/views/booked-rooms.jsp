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
<%-- Welcome ${user.firstname} to the hotel booking
<div style="float: right;">
<h1>${user.firstname}</h1>
<a href="${pageContext.request.contextPath}">Logout</a>
</div>
<br>
<br>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br><br><br> --%>
<div class="container">
	<c:if test="${not empty allBookedRooms}">
		<h2>All Booked Rooms</h2>
        <table class="center">
			<tr>
				<td><b>BOOKING ID</b></td>
				<td><b>BOOKED UNDER THE NAME</b></td>
				<td colspan="2"><b>ROOM DETAILS</b></td>
				<td><b>CHECK-IN DATE</b></td>
				<td><b>CHECK-OUT DATE</b></td>			
				<td><b>NO OF DAYS</b></td>
				 <td><b>STATUS</b></td>
				
			</tr>
			<c:forEach var="roomBook" items="${allBookedRooms}">
				<tr>
					<td>${roomBook.bookingID}</td>
					<td>${roomBook.guest.user.firstname}&thinsp;
						${roomBook.guest.user.lastname}</td>
					<td>${roomBook.room.roomNumber}</td>
					<td>${roomBook.room.roomType}</td>
					<td>${roomBook.checkIn}</td>
					<td>${roomBook.checkOut}</td>
					<td>${roomBook.numOfDays}</td>
					<td>${roomBook.roomStatus}</td>					
				</tr>
			</c:forEach>
		</table>

    </c:if>
	<c:if test="${empty allBookedRooms}">
		<h3>No Rooms Booked By the Guest!!</h3>
	</c:if>

	</div>
	</body>
</html>