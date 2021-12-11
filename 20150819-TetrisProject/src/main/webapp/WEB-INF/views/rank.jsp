<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
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
	<div class="container">
		<div style="padding-top: 50px">
			<table id="rankTable" class="table table-hover">
				<!-- <tr>
					<th>랭킹</th>
					<th>사용자ID</th>
					<th>최고 점수</th>
					<th>갱신 날짜</th>
				</tr>
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				 -->
			</table>
			<a href="./title" class="btn btn-secondary">&laquo; 뒤로가기</a>
		</div>
		<hr>
	</div>	
</c:if>
</body>
</html>
<script type="text/javascript">

init();

function init(){
	
	document.querySelector("#rankTable").innerHTML = "";
	
	let html = '';
	html += '<tr>';
	html +=     '<th>랭킹</th>';
	html +=		'<th>사용자ID</th>';
	html +=		'<th>최고 점수</th>';
	html +=		'<th>갱신 날짜</th>';
	html +=	'</tr>';
	
	fetch('./api/rank', {
	    method: 'get',
	    headers: {}
	  })
	  .then((res) => {
	      return res.json();
	  })
	  .then((json) => {
		  console.log(json.userRankInfos);
		  
		  var rankInfoArr = json.userRankInfos;
		  var rankCnt = 1;
		  
		  rankInfoArr.forEach(item =>{
			  html += '<tr>';
			  html +=   '<td>' + rankCnt + '</td>';
			  html += 	'<td>' + item.username + '</td>';
			  html += 	'<td>' + item.score + '</td>';
			  html += 	'<td>' + item.modifyDate + '</td>';
			  html += '</tr>';
			  
			  rankCnt++;
		  });
		  
		  document.querySelector("#rankTable").innerHTML += html;
	  })	  
}
	
</script>