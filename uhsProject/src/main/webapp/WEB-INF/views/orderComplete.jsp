<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>주문 정보</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				주문 정보
			</h1>
		</div>
	</div>
	
	<div class="container col-8 alert alert-info">
		<div class="text-center">
			<h1>주문 내역</h1>
		</div>
	</div>
	<div class="row justify-content-between">
		<div class="col-4" align="left">
			<strong>배송 주소</strong> <br>		
			성명 : <a id="name"></a> <br>
			우편번호 : <a id="zipCode"></a> <br>
			주소 : <a id="address"></a> <br>
		</div> 
		<div class="col-4" align="right">
			<em>주문일 : <a id="shippingDay"></a></em>
		</div>
	</div>
		<table id="orderTable" class="table table-hover">
			<!-- <tr>
				<th class="text-center">상품</th>
				<th class="text-center">#</th>
				<th class="text-center">가격</th>
				<th class="text-center">소계</th>
			</tr> -->
		</table>
		
		<a href="./product" class="btn btn-warning">확인 &raquo;</a>
			
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>
