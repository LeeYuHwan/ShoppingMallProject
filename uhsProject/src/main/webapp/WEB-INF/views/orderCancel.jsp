<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>주문 취소</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				주문 취소
			</h1>
		</div>
	</div>
	
	<div class="container">
		<h2 class="alert alert-danger">주문을 취소하였습니다.</h2>
	</div>
	
	<div class="container">
		<p><a href="./product">&laquo; 상품 목록</a></p>
	</div>
		
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>