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
<style>
	.mainDiv {
	  display: flex;
	  align-items: center;
	  flex-direction: column; 
	  justify-content: center;
	  width: 100%;
	  min-height: 100%;
	}
</style>
</head>
<body>
<c:if test="${empty id}">
	<div class="mainDiv">
		<div>로그인이 필요한 서비스 입니다.</div>
		<a href="./login">뒤로가기</a>
	</div>
</c:if>
<c:if test="${! empty id}">
	<!------ Include the above in your HEAD tag ---------->

	<div class="wrapper fadeInDown">

	    <!-- Tabs Titles -->
	
	<!--     Icon
	    <div class="fadeIn first">
	      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="Welcome To Tetris World" />
	    </div> -->
	
	    <!-- Login Form -->
	    <div>
	      <img src="./resources/img/테트리스.jpg" alt="테트리스_메인">
	    </div>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a class="btn btn-primary pull-right" href="./home">게임 시작</a>
	      <br>
	      <a class="underlineHover" href="./logout">로그아웃</a>
	      <br>
	      <a class="underlineHover" href="./rank">랭킹</a>
	      <br>
	      <a class="underlineHover" href="./delete-member">회원탈퇴</a>
	    </div>
	

	</div>
</c:if>

</body>
</html>