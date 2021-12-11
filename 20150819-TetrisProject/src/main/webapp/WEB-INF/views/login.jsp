<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./resources/css/login.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Welcome To Tetris World</title>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

<!--     Icon
    <div class="fadeIn first">
      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="Welcome To Tetris World" />
    </div> -->

    <!-- Login Form -->
    <form>
      <input type="text" id="username" class="fadeIn second" name="login" placeholder="login">
      <input type="password" id="password" class="fadeIn third" name="login" placeholder="password">
      <a id="login" onclick="login();" class="fadeIn fourth">Log In</a>
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="./findpw">Forgot Password?</a>
      <br>
      <a class="underlineHover" href="./sign-up">Sign Up</a>     
    </div>

  </div>
</div>
</body>
</html>
<script type="text/javascript">
	function login(){					
	    let username = document.querySelector("#username").value;
	    let password = document.querySelector("#password").value;
	    	    
	    const formData = new FormData();
	    formData.append("username", username);
	    formData.append("password", password);
		
		fetch('./api/auth/login', {
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

