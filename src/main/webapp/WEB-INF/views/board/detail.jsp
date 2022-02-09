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
<!-- handlebars cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" ></script>
<!-- 댓글리스트 탬플릿 소스 -->
<script id="template_source" type="text/x-handlebars-template">
{{#each .}}
	<hr>
	{{#levelSpace relevel}} <!-- levelSpace : 헬퍼의 이름 -->
	{{/levelSpace}}
	<div id="reply{{rnum}}">
		번호 :{{rnum}} 
			restep: <span id="restep{{rnum}}">{{restep}}</span>  
			relevel: <span id="relevel{{rnum}}">{{relevel}}</span><br>
		이메일 : {{email}} <br>
		내용 : <span id="content{{rnum}}">{{content}}</span> <br> 
		<button class="btnReReplyAdd" value="{{rnum}}">댓글</button>
		<button class="btnReReplyModify" value="{{rnum}}">수정</button>
		<button class="btnReReplyRemove" value="{{rnum}}">삭제</button>
	</div>
{{/each}}
</script>

<script type="text/javascript">
	//핸들바의 헬퍼 작성
	//relevel(레벨)에 따라서 반복문 헬퍼
	Handlebars.registerHelper('levelSpace', function(relevel) {
		var result='';
		for(var i=0; i<relevel; i++){
			result += '<i class="fab fa-replyd"></i>';
		}
		return result;
	});

	$(function() {
		//삭제버튼을 클릭했을때
		$('#btnRemove').on('click', function() {
			//본인의 게시물만 삭제가능
			if ('${result.board.email}'!='${sessionScope.email}'){
				alert('삭제 권한이 없습니다.');
				return ;
			}
			
			
			if (confirm('삭제하시겠습니까?'))
				location.href = '${path}/board/remove?bnum=${result.board.bnum}';
		});
		
		//수정버튼을 클릭했을때
		$('#btnModify').on('click', function() {
			location.href = '${path}/board/modify?bnum=${result.board.bnum}';
		});
	
	
		
		//수정창의 수정버튼을 클릭했을때
		$('#btnReplyModify').on('click', function() {
			var rnum = $('#rnum').val();
			var content = $('#replycontentModify').val();
			console.log(rnum);
			console.log(content);
			$.ajax({
				url:'${path}/reply/',
				type:'put', //수정 method
				data:JSON.stringify({rnum,content}),
				contentType:'application/json',
				dataType:'text',
				success: function(data) {
					console.log(data);
					
					
				},
				error: function(e) {
					console.log(e);
					alert('실패');
				}					
			});
			
		});
		
		
		
		
		
	});

</script>
</head>
<body>
<div class="container">
	
	<div id="header">
		<%@ include file="../header.jsp" %>
	</div>
	<h2>상세조회</h2>
<%-- 	${result.board}
	<hr>
	${result.bflist} --%>
		
	<table id="tblBoardDetail" class="table table-bordered ">
		<tr>
			<th>번호</th>
			<td>${result.board.bnum}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${result.board.email}</td>
		</tr>	
		<tr>
			<th>제목</th>
			<td>${result.board.subject}</td>
		</tr>	
		<tr>
			<th>내용</th>
			<td><pre>${result.board.content}</pre></td>
		</tr>	
		
		<tr>
			<td colspan="2">
				조회수:${result.board.readcnt}
				
			</td>
		</tr>		
		<tr>
			<th>등록일자</th>
			<td><fmt:formatDate value="${result.board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${result.board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="btnModify" >수정</button>
				<button id="btnRemove" >삭제</button>
				
			</td>
		</tr>
	</table>
	
	
</div>



</body>
</html>
	