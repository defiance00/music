<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#header {
		height: 140px;
		
	}
	
</style>
<script type="text/javascript">
	$(function() {
	
		$('#btnModify').on('click', function(e){
			e.preventDefault();
			var subject =$('#subject').val();
			var content =$('#content').val();
			if(subject==''){
				alert('제목을입력해주세요');
				$('#subject').focus();
			}else if(content=='') {
				
					alert('내용을입력해주세요');
					$('#content').focus();
			}else{
				$("#frmModify").attr('action', '${path}/board/modify')
				.attr('method', 'post')
				.attr('enctype', 'multipart/form-data')
				.submit();
				
			}
		});
		
	});

</script>
</head>
<body>
<div class="container">
	<div id="header">
		<%@ include file="../header.jsp" %>
	</div>
	
	<h2>수정</h2>
	<%-- ${result} --%>
	
	<form id="frmModify">
	<table border="1">
		<tr>
			<th>번호</th>
			<td> <input type="text" name="bnum" id="bnum" value="${result.board.bnum}" readonly> </td>
		</tr>	
		<tr>
			<th>이메일</th>
			<td> <input type="email" name="email" id="email" value="${result.board.email}" readonly> </td>
		</tr>	
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" id="subject" value="${result.board.subject}"></td>
		</tr>	
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="20" name="content" id="content">${result.board.content}</textarea></td>
		</tr>	
	
		<tr>
			<td colspan="2" align="center">
				<button id="btnModify">수정</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>		
	
	</form>	
</div>	
</body>
</html>