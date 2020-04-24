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
<%-- 
Welcome ${user.firstname} to the hotel booking
<div style="float: right;">
<h1>${user.firstname}</h1>
<a href="${pageContext.request.contextPath}">Logout</a>
</div>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br><br><br>
<br>
<br> --%>
<h2>Guests List</h2>
    <div>
		<table class="center">
			<tr>
				<td><b> ID</b></td>
				<td><b> FIRSTNAME</b></td>
				<td><b> LASTNAME</b></td>
				<td><b> ADDRESS</b></td>
				<td><b>STATE </b></td>
				<td><b>ZIPCODE</b></td>
				<td><b>PHONE NUMBER</b>
				<td><b>EMAIL-ID</b></td>
				
			</tr>
			<c:forEach var="guest" items="${guests}">
				<tr>
					<td>${guest.guest_id}</td>
					<td>${guest.user.firstname}</td>
					<td>${guest.user.lastname}</td>
					<td>${guest.address}</td>
					<td>${guest.state}</td>
					<td>${guest.zipcode}</td>
					<td>${guest.phNum}</td>
					<td>${guest.emailID}</td>					
				</tr>
			</c:forEach>
		</table>


	</div>

			
</body>
</html>