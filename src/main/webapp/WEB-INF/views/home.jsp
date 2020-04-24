<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.jumbotron {
	margin-bottom: 0;
}
#textcenter{
	padding-left: 5%;
	color:  white;
}
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}
#frame {
	border: 1px solid grey;
	background-size: 100%;
	background-image:
		url(/images/background.jpg);
	background-repeat: no-repeat;
	background-position: center;
	
}


</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<div class="jumbotron" id="mainFrame">
		 <div id="textcenter">
		   <h1 class="display-4">Hotel Booking!!</h1>
		  <p class="lead">Welcome to Hyatt Hotel</p>
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
					<li class="active"><a href="">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${contextPath}/login">Login</a></li>					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${contextPath}/register">Register</a></li>
				</ul>
		   </div>
		  </div>
		  </nav>
		   

	
	
	
	<div class="container">
		<h2>My Hotel</h2>
		<c:forEach var="room" items="${rooms}">
			<div class="col-md-3">
				<h3>
						<span>${room.roomType}</span>
					</h3>
					<h5> ${room.roomDesc}</h5>
					<h5> ${room.roomPrice}</h5>
					<figure>
						<img width="200px" height="250px" src="${room.filename}" alt="Room photo" />
					</figure>
			</div>
		</c:forEach>
	</div>
        
</body>
</html>
