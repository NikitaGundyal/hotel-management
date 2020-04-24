<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h1>Login Section</h1>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form action="${contextPath}/login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>




	<%-- <h1>Login Section</h1>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <form action="${contextPath}/login" method="post">
        
           <label>Username:</label>
           <input type="text" name="username"/><br>
           
           <label>Password:</label>
           <input type="password" name="password"/><br>
           
           <input type="submit" value="Login"/>        
        </form> --%>
      
        <br/><br/><br/><br/><br/><br/><br/>
</body>
</html>