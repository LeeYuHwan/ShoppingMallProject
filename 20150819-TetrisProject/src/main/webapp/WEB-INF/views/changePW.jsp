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
	.mainDiv {
	  display: flex;
	  align-items: center;
	  flex-direction: column; 
	  justify-content: center;
	  width: 100%;
	  min-height: 100%;
	}
</style>
<title>Change PassWord</title>
</head>

<!------ Include the above in your HEAD tag ---------->

<body>
<c:if test="${empty changeId}">
	<div class="mainDiv">
		<div>접근이 불가능 합니다.</div>
		<a href="./login">뒤로가기</a>
	</div>
</c:if>
<c:if test="${! empty changeId}">
	<div class="wrapper">
		<div class="span3">
		    <h2>${changeId} Change PassWord</h2>
		    <form>
		    <label>Password</label>
		    <input id="password" type="password" name="password" class="span3">
		    <a onclick="changePw();" class="btn btn-primary pull-right">Change PassWord</a> 
		    <a href="./login" class="btn btn-primary pull-right">Back</a>  
		    </form>    
		</div>
	</div>
</c:if>
</body>
</html>
<script type="text/javascript">
	function changePw(){		
		let username = '${changeId}';
	    let password = document.querySelector("#password").value;
	    	    		
		fetch('./api/auth', {
		    method: 'put',
		    headers: {"Content-Type": "application/json"},
		    body: JSON.stringify({
		    	"username":username,
		    	"password":password
		    }),	    
		  })
		  .then((res) => {
		      return res.json();
		  })
		  .then((json) => {
			  alert(json.message);
			  location.href = json.returnUrl;
		  })
	}
</script>