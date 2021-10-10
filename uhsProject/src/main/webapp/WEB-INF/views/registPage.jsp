<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>상품 등록</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				상품 등록
			</h1>
		</div>
	</div>

	<div class="container">
		<div class="form-group row">
			<label class="col-sm-2">상품 코드</label>
			<div class="col-sm-3">
				<input type="text" id="productId" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상품명</label>
			<div class="col-sm-3">
				<input type="text" id="productName" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">가격</label>
			<div class="col-sm-5">
				<input type="number" id="productPrice" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상세 정보</label>
			<div class="col-sm-5">
				<textarea id="productInfo"rows="2" cols="50"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">제조사</label>
			<div class="col-sm-3">
				<input type="text" id="productMaker" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">분류</label>
			<div class="col-sm-3">
				<input type="text" id="productCategory" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">제고 수</label>
			<div class="col-sm-3">
				<input type="number" id="productStock" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상태</label>
			<div class="col-sm-5">
				<input type="radio" name="productCondition" value="New" checked> 신규 제품
				<input type="radio" name="productCondition" value="Old"> 중고 제품
				<input type="radio" name="productCondition" value="Refurbished"> 재생 제품
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="button" id="registBtn" class="btn btn-primary" value="등록" onclick="registProduct();">
			</div>
		</div>
	</div>
		
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>

<script type="text/javascript">	
	function registProduct(){					
		let productId = document.querySelector("#productId").value;
	    let pname = document.querySelector("#productName").value;
	    let unitPrice = document.querySelector("#productPrice").value;
	    let description = document.querySelector("#productInfo").value;
	    let manufacturer = document.querySelector("#productMaker").value;
	    let category = document.querySelector("#productCategory").value;
	    let unitsInstock = document.querySelector("#productStock").value;
	    let pcondition = document.querySelector("input[name='productCondition']:checked").value;
		
		fetch('./registration', {
		    method: 'post',
		    headers: {
		        "Content-Type": "application/json",
		    },
		    body: JSON.stringify({
		    	productId: productId,
			    pname: pname,
			    unitPrice: unitPrice,
			    description: description,
			    manufacturer: manufacturer,
			    category: category,
			    unitsInstock: unitsInstock,
			    pcondition: pcondition
		    })
		  })
		  .then((response) => {
			  location.href = response.url;
		  })
	}
</script>