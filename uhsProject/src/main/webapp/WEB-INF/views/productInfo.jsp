<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>상품 상세 정보</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				상품 정보
			</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<c:if test="${imgName != null }">
				<div class="col-md-5">			
					<img src="./resources/img/${imgName}" style="width: 100%">				
				</div>
			</c:if>	
			<div class="col-md-6">
				<h3>${pname}</h3>
				<p>${description}</p>
				<p><b>상품 코드 : </b><span class="badge badge-danger">${productId}</span></p>
				<p><b>제조사 : </b>${manufacturer}</p>
				<p><b>분류 : </b>${category}</p>
				<p><b>재고 수 : </b>${unitsInstock}</p>
				<h4>${unitPrice}원</h4>
				<p><a href="#" class="btn btn-info">상품 주문 &raquo;</a>
				   <a href="./product" class="btn btn-secondary">상품 목록 &raquo;</a></p>
			</div>
		</div>
	</div>
		
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>