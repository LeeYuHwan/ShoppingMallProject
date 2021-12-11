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
<title>Membership Withdrawal</title>
</head>

<!------ Include the above in your HEAD tag ---------->

<body>
<c:if test="${empty id}">
	<div class="mainDiv">
		<div>로그인이 필요한 서비스 입니다.</div>
		<a href="./login">뒤로가기</a>
	</div>
</c:if>
<c:if test="${! empty id}">
	<div class="wrapper">
		<div class="span3">
		    <h2>Membership Withdrawal</h2>
		    <form>
		    <label>Password</label>
		    <input id="password" type="password" name="password" class="span3">
		    <a onclick="withdrawalMember();" class="btn btn-primary pull-right">Membership Withdrawal</a> 
		    <a href="./title" class="btn btn-primary pull-right">Back</a>  
		    </form>    
		</div>
	</div>
</c:if>
</body>
</html>
<script type="text/javascript">
	function withdrawalMember(){
		let username = '${id}';
	    let password = document.querySelector("#password").value;
	    	    
	    const formData = new FormData();
	    formData.append("username", username);
	    formData.append("password", password);
		
		fetch('./api/auth/withdrawal', {
		    method: 'post',
		    body: formData,
		    headers: {}
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