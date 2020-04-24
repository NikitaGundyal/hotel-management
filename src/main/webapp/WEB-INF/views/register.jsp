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
<h1>Registration Section</h1>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container">
		<form:form action="${contextPath}/register" method="post" commandName="guest" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">First Name:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="user.firstname"
						placeholder="Enter First name"  required="true"/>
					<font color="blue"><form:errors path="user.firstname"></form:errors></font>
				</div>
			</div>			 
			<div class="form-group">
				<label class="control-label col-sm-2">Last Name:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="user.lastname"
						placeholder="Enter Last"   required="true"/>
					<font color="blue"><form:errors path="user.lastname"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Username:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="user.username"
						placeholder="Enter Username"  required="true" />
					<font color="red"><form:errors path="user.username"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-10">
					<form:input type="password" class="form-control" path="user.password"
						placeholder="Enter Password"  required="true"/>
					<font color="red"><form:errors path="user.password"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Address:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="address"
						placeholder="Enter Address"  required="true"/>
					<font color="red"><form:errors path="address"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">State:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="state"
						placeholder="Enter State"  required="true"/>
					<font color="red"><form:errors path="state"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Zipcode:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="zipcode"
						placeholder="Enter Zipcode" required="true" />
					<font color="red"><form:errors path="zipcode"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Phone Number:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="phNum"
						placeholder="Enter Phone Number"  required="true"/>
					<font color="red"><form:errors path="phNum"></form:errors></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email ID:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="emailID"
						placeholder="Enter Email"  required="true"/>
					<font color="red"><form:errors path="emailID"></form:errors></font>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-secondary btn-lg" value="Register" />
				</div>
			</div>
		</form:form>
	</div>


       <%--  <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="guest">
      
             <label> First Name:</label>
             <form:input path="user.firstname" name="firstname" type="text" /><form:errors path="user.firstname"/><br><br>
             
              <label>Last Name:</label>
             <form:input path="user.lastname" name="lastname" type="text" /><form:errors path="user.lastname"/><br><br>
             
             <label> Username:</label>
             <form:input path="user.username" name="username" type="text" /><form:errors path="user.username"/><br><br>
             
              <label>Password:</label>
             <form:input path="user.password" name="password" type="text" /><form:errors path="user.password"/><br><br>
             
             <label> Address:</label>
             <form:input path="address" name="address" type="text" /><form:errors path="address"/><br><br>
             
             <label> State:</label>
             <form:input path="state" name="state" type="text" /><form:errors path="state"/><br><br>
             
              <label> Zipcode:</label>
             <form:input path="zipcode" name="zipcode" type="text" /><form:errors path="zipcode"/><br><br>
             
             <label> Phone Number:</label>
             <form:input path="phNum"  name="phNum" type="text" /><form:errors path="phNum"/><br><br>
             
             <label> Email ID:</label>
             <form:input path="emailID" name="emaildID" type="text" /> <form:errors path="emailID"/><br><br>         
        
             <input type="submit" value="Register" />
         
  </form:form>
 --%>
</body>
</html>