<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>Welcome</title>
</head>
<body>
	<nav class = "navbar navbar-expand navbar-dark bg-dark">
		<div class = "container">
			<div class = "navbar-header">
				<a class = "navbar-header" href="./">Home &nbsp;&nbsp;</a>	
				<!-- a class = "navbar-header" href="#" id="loginInfoShow" style="display:none;">이유환님, 반갑습니다. &nbsp;&nbsp;</a>	
				<a class = "navbar-header" href="#" onclick="loginBtn();" id="loginMenu">로그인</a> -->
				<a class = "navbar-header" href="./product" id="loginMenu">Product</a>			
			</div>			
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				${greeting }
			</h1>
		</div>
	</div>
	
	<main role="main">
		<div class="container">
			<div class="text-container" style="text-align: center;">
				<h3>
					${tagline } 			
				</h3>
				현재 접속 시각 : ${currentTime }
			</div>
			<hr>
		</div>
	</main>
	
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>

<script type="text/javascript">
	function loginBtn(){
		if(document.querySelector("#loginMenu").innerText == "로그인"){
			document.querySelector("#loginMenu").innerText="로그아웃";
			document.querySelector("#loginInfoShow").style.display="";
		}
		else{
			document.querySelector("#loginMenu").innerText="로그인";
			document.querySelector("#loginInfoShow").style.display="none";
		}
		
	}
</script>