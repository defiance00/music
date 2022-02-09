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
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.frmModify.addr.value = roadAddrPart1;//도로명
	document.frmModify.addrdetail.value = addrDetail;//상세주소
	document.frmModify.zipcode.value = zipNo;//우편번호
	
}
$(function() {
	$('#findaddr').on('click', function() {
		//WEB-INF하위 폴더는 직접 접근 불가
		// /app/WEB-INF/views/member/jusoPopup.jsp
		var pop = window.open('/app/member/jusoPopup','juso','width=570,height=420,scrollbars=yes,resizable=yes');
	});
	
	//수정버튼을 클릭했을때 
	$('#btnModify').on('click', function(e){
		e.preventDefault();
		var passwd = $('#passwd').val();
		console.log(passwd);
		if(passwd==''){
			alert('기존 비밀번호를 입력해주세요');
			$('#passwd').focus();
			return ;
			
		}
		$('#frmModify').attr('action', '${path}/member/modify').submit();
		
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
	${member}
 	<form id="frmModify" name = "frmModify" action=""  method="post" enctype="multipart/form-data">
		<table border = "1">
			<tr>
				<th>이메일</th>
				<td colspan="2"> <input type="email" name="email" value="${member.email}" readonly> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="2"> 
					기존:<input type="password" name="passwd"><hr>
					변경:<input type="password" name="newpasswd"> 
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2"> 
					<input type="text" name="zipcode" size="5" value="${member.zipcode}"> 
						<button type="button" id="findaddr">찾기</button>
					<hr>
					<input type="text" name="addr" size="40" value="${member.addr}"><br>
					<input type="text" name="addrdetail" size="40" value="${member.addrdetail}">
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="center"> 
					<button>수정</button> <button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>	
</div>
	
</body>
</html>