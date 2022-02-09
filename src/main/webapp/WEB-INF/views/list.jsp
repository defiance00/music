<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 부트스트랩 연결 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
	#header {
		height: 100px;
		
	}
	
	
	
	

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//검색버튼을 클릭했을때
		$('#btn-find').on('click', function(){
		
			var findvalue=$('#findvalue').val();		
			if (findvalue==''){
				alert('찾으려는 트랙명 or 아티스트를 입력해주세요');
				$('#findvalue').focus();
				return;
			}
			else{
				frmlist.submit();
			}
				
		});

	});

</script>
</head>

<body>
<div id="header">
	<%@ include file="./header.jsp" %>
</div>
  
<div class="container">
	<h2>last.fm Search</h2>
	
	<!-- 검색창 -->
	<form name = "frmlist" class="form-inline" action="/app/music/" method="get">
		<div class="form-group">
			<select class="form-control" name="findkey" id="findkey">
				<option value="name" <c:out value="${findkey=='name'?'selected':''}"/>>트랙명</option>
				<option value="artist" <c:out value="${findkey=='artist'?'selected':''}"/>>아티스트</option>
				
			</select>
			<input class="form-control mr-sm-2" placeholder="Search" name="findvalue" id="findvalue" value="${findvalue}">
			<button class="btn btn-success" id="btn-find" type="button">검색</button>
		</div>
	</form>

	<!-- 앨범명으로 검색 -->
	<c:if test="${findkey=='name'}">
		<table border=1  class="table table-striped">
			<tr>
				<th>트랙명</th>
				<th>아티스트</th>
				<th>URL</th>
			</tr>
	
			<c:forEach var="music" items="${mlist }">
				<tr>
					<th>${music.name }</th>
					<th>${music.artist }</th>
					<th><a href="${music.url}">${music.url}</a></th>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<!-- 아티스트검색 -->
	<c:if test="${findkey=='artist'}">
		<table border=1  class="table table-striped">
			<tr>
				<th>아티스트</th>
				
				<th>URL</th>
			</tr>
			<c:forEach var="music" items="${mlist}">
				<tr>
					<th>${music.name }</th>
					
					<th><a href="${music.url}">${music.url}</a></th>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
</div>
</body>
</html>