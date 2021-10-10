<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>상품 목록</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				상품 목록
			</h1>
		</div>
	</div>
	
	<main role="main">
		<div class="container" >
			<div class="text-container">
				<div class="row">		
					<div class="col-md-9 cont">
						<div class="row" align = "center">
							<c:forEach items="${listOfProducts	}" var="data">
								<div class="col-md-4">
									<p>
										<h3>${data.pname}</h3>
										${data.description } <br>
										${data.unitPrice } 원
									</p>
								</div>
							</c:forEach>
						</div>				
					</div>
				</div>
			</div>
			<hr>
		</div>
	</main>
	
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>