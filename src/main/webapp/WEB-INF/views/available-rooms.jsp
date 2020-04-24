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
<br>
<br>
<a href="${pageContext.request.contextPath}/home">Home</a><br><br><br><br> --%>

		<div>
			<h3>Book your room!These are the available rooms</h3>
			<c:if test="${not empty availableRooms}">
			<c:forEach var="room" items="${availableRooms}">
			<form:form action="${pageContext.request.contextPath}/guest/roomBookRequest.htm"
				method="post" commandName="reserveRoom">
				<div>
				   <div class="col-md-3">
						<h3>
							<span>${room.roomType}</span>
						</h3>
						
						<h3>
							<span>${room.roomDesc}</span>
						</h3>
						<figure>
							<img width="200px" height="250px" src="${room.filename}"
								class="img-rounded" alt="Room photo" />
						</figure>
					</div>
					<div>
						<br> <label>Room</label>
						<select  name="roomid">
							<c:forEach var="availRoom" items="${availableRooms}">
								<option value="${availRoom.id}">${availRoom.roomType}</option>
							</c:forEach>
						</select>
					</div>
					<div style="display: inline-block">
						<label></i>Check In Date :</label>
						<form:input path="checkIn" type="date" name="checkIn" id="checkIn" onchange="cal()"/>
					</div>
					<div style="display: inline-block">
						<label></i>Check Out Date :</label>
						<form:input path="checkOut" type="date" name="checkOut" id="checkOut" onchange="cal()"/>
					</div>
					
              <div id="numdays">
              <label>Number of days:</label>
                 <input type="text" class="textbox" id="numdays2" name="numdays"/>
               </div>

					<div >
						<br>
						<div >
						
							<input type="submit" value="Book" />
							<input type="reset" value="Reset" />
						</div>
					</div>

				</div>
			</form:form>			
			</c:forEach>
			 </c:if>
			
		</div>
		
		<c:if test="${empty availableRooms}">
				<h3>No Rooms Available</h3>
			</c:if>
	<script>
        function GetDays(){
                var checkInDate = new Date(document.getElementById("checkIn").value);
                var checkOutDate = new Date(document.getElementById("checkOut").value);
                console.log(parseInt((checkOutDate - checkInDate) / (24 * 3600 * 1000)));
                return parseInt((checkOutDate - checkInDate) / (24 * 3600 * 1000));
        }

        function cal(){
        if(document.getElementById("checkOut")){
            document.getElementById("numdays2").value=GetDays();
        }
        }  
    
		

</body>
</html>