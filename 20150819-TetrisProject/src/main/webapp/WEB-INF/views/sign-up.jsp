<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
	.wrapper {
	  display: flex;
	  align-items: center;
	  flex-direction: column; 
	  justify-content: center;
	  width: 100%;
	  min-height: 100%;
	  padding: 20px;
	}
</style>
<title>Sign Up</title>
</head>

<!------ Include the above in your HEAD tag ---------->

<body>
	<div class="wrapper">
		<div class="span3">
		    <h2>Sign Up</h2>
		    <form>
		    <label>First Name</label>
		    <input id="firstname" type="text" name="firstname" class="span3">
		    <label>Last Name</label>
		    <input id="lastname" type="text" name="lastname" class="span3">
		    <label>Email Address</label>
		    <input id="email" type="text" name="email" class="span3">
		    <label>ID</label>
		    <input id="username" type="text" name="username" class="span3">
		    <label>Password</label>
		    <input id="password" type="password" name="password" class="span3">
		    <a onclick="registUser();" class="btn btn-primary pull-right">Sign up</a> 
		    <a href="./" class="btn btn-primary pull-right">Back</a>  
		    </form>    
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	function registUser(){					
		let firstname = document.querySelector("#firstname").value;
	    let lastname = document.querySelector("#lastname").value;
	    let email = document.querySelector("#email").value;
	    let username = document.querySelector("#username").value;
	    let password = document.querySelector("#password").value;
	    	    
	    const formData = new FormData();
	    formData.append("firstname", firstname);
	    formData.append("lastname", lastname);
	    formData.append("email", email);
	    formData.append("username", username);
	    formData.append("password", password);
		
		fetch('./api/auth', {
		    method: 'post',
		    body: formData,
		    headers: {}
		  })
		  .then((res) => {
		      return res.json();
		  })
		  .then((json) => {
			  console.log(json);
			  
			  alert(json.message);
			  location.href = json.returnUrl;
		  })
	}
</script>