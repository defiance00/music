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
<!-- 다운받은 jquery연결 -->
<script src="/app/resources/js/jquery-3.6.0.js" type="text/javascript"></script>

<script type="text/javascript">
//jusoPopup.jsp에서 실행할 함수
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.frmJoin.addr.value = roadAddrPart1;//도로명
	document.frmJoin.addrdetail.value = addrDetail;//상세주소
	document.frmJoin.zipcode.value = zipNo;//우편번호
	
}

	$(function() {
		$('#findaddr').on('click', function() {
			//WEB-INF하위 폴더는 직접 접근 불가
			// /app/WEB-INF/views/member/jusoPopup.jsp
			var pop = window.open('${path}/member/jusoPopup','juso','width=570,height=420,scrollbars=yes,resizable=yes');
		});
	});

</script>
</head>
<body>
<div id="header">
	<%@ include file="../header.jsp" %>
</div>
<div class="container">
	<h2>회원가입</h2>
	<form name = "frmJoin" action="${path}/member/join" method="post" enctype="multipart/form-data">
		<table border = "1">
			<tr>
				<th>이메일</th>
				<td> <input type="email" name="email"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input type="password" name="passwd"> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td> 
					<input type="text" name="zipcode" size="5"> 
						<button type="button" id="findaddr">찾기</button>
					<hr>
					<input type="text" name="addr" size="40"><br>
					<input type="text" name="addrdetail" size="40">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"> 
					<button>가입</button> <button type="reset">취소</button>
				</td>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>