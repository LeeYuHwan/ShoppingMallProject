<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>배송 정보</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				배송 정보
			</h1>
		</div>
	</div>

	<div class="container">
		<div class="form-group row">
			<label class="col-sm-2">성명</label>
			<div class="col-sm-3">
				<input type="text" id="name" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">주문일</label>
			<div class="col-sm-3">
				<input type="text" id="shippingDay" class="form-control" readonly>(yyyy/mm/dd)
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">국가</label>
			<div class="col-sm-5">
				<input type="text" id="country" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">우편번호</label>
			<div class="col-sm-5">
				<input type="text" id="zipCode" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">주소</label>
			<div class="col-sm-3">
				<input type="text" id="address" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="./product" class="btn btn-info">이전 &raquo;</a>
				<a onclick="orderStart();" class="btn btn-warning">주문 &raquo;</a>
				<a href="./product" class="btn btn-secondary">취소 &raquo;</a>
			</div>
		</div>
	</div>
		
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>

<script type="text/javascript">	
	document.querySelector("#shippingDay").value = toDayFormet();
	
	function orderStart(){					
		let productId = getParameterByName("id");
		let name = document.querySelector("#name").value;
	    let shippingDay = document.querySelector("#shippingDay").value;
	    let country = document.querySelector("#country").value;
	    let zipCode = document.querySelector("#zipCode").value;
	    let address = document.querySelector("#address").value;

	    const formData = new FormData();
	    formData.append("productId", productId);
	    formData.append("name", name);
	    formData.append("shippingDay", shippingDay);
	    formData.append("country", country);
	    formData.append("zipCode", zipCode);
	    formData.append("address", address);
    
		fetch('./api/orderer', {
		    method: 'post',
		    body: formData,
		    headers: {}
		  })
		  .then((response) => {
			  location.href = response.url;
		  })
	}
	
	function getParameterByName(name) { 
		name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]"); 
		var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		results = regex.exec(location.search); 
		return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " ")); 
	}
	
	function toDayFormet(){
		let today = new Date();	
		let year = today.getFullYear();
		let month = ('0' + (today.getMonth() + 1)).slice(-2);
		let day = ('0' + today.getDate()).slice(-2);	
		let dateString = year + '/' + month  + '/' + day;
		
		return dateString;
	}
</script>