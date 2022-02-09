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
		//파일 추가 아이콘 클릭
		$('.addfile').on('click', function() {
			var li = $('<li/>').append('<input type="file" name="files">')
							   .append('<i class="fas fa-minus-circle removefile"></i>');
			$('#filelist').append(li);
			//$('#filelist').append('<li><input type="file" name="bfiles"><i class="fas fa-minus-circle removefile"></i></li>');
		});
		
		//파일 삭제 아이콘 클릭
		//동적으로 생성된 엘리먼트에 이벤트달기
		
		$('#filelist').on('click', '.removefile', function(){
			$(this).parent().remove();
			
		});
		
		//저장버튼을 클릭했을때
		$("#btnAdd").on('click',function(e){
			e.preventDefault();
			var email=$('#email').val();
			var subject=$('#subject').val();
			var content=$('#content').val();
			if(email==''){
				alert('이메일을 입력해주세요');
				$('#email').focus();
			}else if(subject==''){
				alert('제목을 입력해주세요');
				$('#subject').focus();
			}else if(content==''){
				alert('내용을 입력해주세요');
				$('#content').focus();
			}else{
				$("#frmAdd").attr('action', '${path}/board/add')
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
	
	<h2>게시물등록</h2>
	<form action="" id="frmAdd">
	<table class="table table-bordered ">
		<tr>
			<th>이메일</th>
			<td> <input type="email" name="email"> </td>
		</tr>	
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject"></td>
		</tr>	
		<tr>
			<th>내용</th>
			<td><textarea class ="form-control" rows="5" cols="20" name="content"></textarea></td>
		</tr>	
		
		<tr>
			<td colspan="2" align="center">
				<button id="btnAdd">등록</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>		
	
	</form>
</div>
	
	
</body>
</html>