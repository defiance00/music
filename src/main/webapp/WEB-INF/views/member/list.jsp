<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	$(function() {
		$(".btnList").on('click', function(){
			var findvalue= $('#findvalue').val();
			location.href='${path}/member/list?findvalue='+findvalue;
			
			
			
			});
	});

</script>


</head>
<body>
	<h2>회원리스트</h2>
	이메일<input type="text" id="findvalue" value="${param.findvalue }">
	<button class="btnList">조회</button>
	<table border="1">
		<tr>
			<th>이메일</th>
			<th>도로명주소</th>
			<th>등록일자</th>
		
		</tr>
	
	
	
		
		<c:forEach var="member" items="${mlist }">
			<tr>
				<td><a href="${path}/member/modify?email=${member.email }">${member.email }</a></td>
				<td>${member.addr }</td>
				<td><fmt:formatDate value="${member.regidate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
		
		
		</c:forEach>
	</table>
	
	
</body>
</html>