<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>장바구니</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				장바구니
			</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<table>
				<tr>
					<td align="left"><a onclick="deleteCart();" class="btn btn-danger">삭제하기</a></td>
					<td align="right"><a href="#" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
		<div style="padding-top: 50px">
			<table id="cartTable" class="table table-hover">
				<!-- <tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a onclick="removeCart();" class="badge badge-danger">삭제</a></td>
				</tr>
				
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th id="sum"></th>
					<th></th>
				</tr> -->
			</table>
			<a href="./product" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
		</div>
		<hr>
	</div>	
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>
<script type="text/javascript">

init();

function init(){
	
	document.querySelector("#cartTable").innerHTML = "";
	
	let name = '';
	let price = 0;
	let cnt = 0;
	let sum = 0;
	let total = 0;
	
	let html = '';
	html += '<tr>';
	html +=		'<th>상품</th>';
	html +=		'<th>가격</th>';
	html +=		'<th>수량</th>';
	html +=		'<th>소계</th>';
	html +=		'<th>비고</th>';
	html +=	'</tr>';
	
	<c:forEach items="${sessionScope.cartlist }" var="data">
		name = '${data.pname}';
		price = ${data.unitPrice};
		cnt = ${data.unitsInstock};
		sum = price * cnt;
		
		html += '<tr>';
		html += 	'<td>' + name + '</td>';
		html += 	'<td>' + price + '원</td>';
		html += 	'<td>' + cnt + '개</td>';
		html += 	'<td>' + sum + '</td>';
		html += 	'<td><a onclick="removeCart(' + ${data.id} + ');" class="badge badge-danger">삭제</a></td>';
		html += '</tr>';
		
		total += sum;
	</c:forEach>
	
	html += '<tr>';
	html +=		'<th></th>';
	html +=		'<th></th>';
	html +=		'<th>총액</th>';
	html +=		'<th>'+ total +'</th>';
	html +=		'<th></th>';
	html +=	'</tr>';
	
	document.querySelector("#cartTable").innerHTML += html;
}

function removeCart(id){
	if(confirm("상품을 장바구니에서 삭제 하시겠습니까?")){		
    	    
		fetch('./api/cart/'+id, {
		    method: 'delete',
		  })
		  .then((response) => {
			  location.href = "./cart";
		  })
	}
}
	
</script>