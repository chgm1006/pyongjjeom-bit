<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Javascript -->

<script src="jquery-1.9.1.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=PT+Sans:400,700">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Oleo+Script:400,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
	
<style>
.ui-datepicker {
	font-size: 12px;
}

.ui-datepicker select.ui-datepicker-month {
	width: 40%;
	font-size: 11px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 50%;
	font-size: 11px;
}
</style>	

<script type="text/javascript">
function test_sample(){
 var sample = document.getElementsByName('radio');
 for(var i=0;i<sample.length;i++){
  if(sample[i].checked == true){
   alert(sample[i].value);
  }
 }
}
</script>


</head>



<body>


<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="upDateMySet.do" method="post">
					<input type="hidden" name="memCD" value="${member.memCD}">
					<h2>
						<span class="red"><strong>평쩜</strong></span>
					</h2>
					<label for="email">이메일</label> 
					<input type="text" id="email" name="email" value = "${member.email}" placeholder="${member.email}" disabled>
					<label for="name">이름</label>
					<input type="text" id="name" name="memNm" value = "${member.memNm}">
					<label for="birth">생년월일</label>
					<input type="text" id="birth" name="birth" value = "${member.birth}">
					<label for="password">비밀번호</label>
					<input type="password" id="password" name="passwd" value = "${member.passwd}">
					<label for="password_check">비밀번호확인</label>
					<input type="password" id="password_check" name="password_check" placeholder="비밀번호확인...">
			\
					<table>
						<tr>
					<td class="item">내 포스팅 공개여부</td>
					<td class="cont">전체공개 <input type="radio" name="open" value="전체공개">
						친구만 공개<input type="radio" name="open" value="친구만 공개"> 비공개<input
						type="radio" name="open" value="비공개">
					</td>
				</tr>
				<tr>
					<td class="item">내 포스팅 댓글 참여 범위</td>
					<td class="cont">
					<input type = "radio" name ="reply" value ="1"/>전체허용<br>
					<input type = "radio" name ="reply" value ="2"/>친구만허용<br>
					<input type = "radio" name ="reply" value ="3"/>허용안함<br>
<!-- 					전체허용<input type="radio" name="reply" value="전체허용">
					친구만 허용<input type="radio" name="reply" value="친구만 허용"> 
					허용안함<input type="radio" name="reply" value="허용안함"> -->
					</td>
				</tr>
				
					</table>
				
					
					
				
					<button type="submit">수정하기</button>
					<button type="button" OnClick="javascript:history.back(-1)">돌아가기</button>
				</form>
			</div>
		</div>
	</div>




<%-- 	<form name=setupFirm method=POST action="upDateMySet.do">
		
			<table>
			<input type="hidden" name="memCD" value="${member.memCD}">
				<tr>
					<td class="item">이름</td>
					<td class="cont"><input type="text" id="memNm" name="memNm" value = "${member.memNm}"></td>
				</tr>
				<tr>
					<td class="item">이메일</td>
					<td class="cont"><input type="text" id="email" name="email" value = "${member.email}"></td>
				</tr>
				<tr>
					<td class="item">생년월일</td>
					<td class="cont"><input type="text" id="birth" name="birth" value = "${member.birth}"></td>
				</tr>
				<tr>
					<td class="item">비밀번호</td>
					<td class="cont"><input type="text" id="passwd" name="passwd" value=""></td>
				</tr>
				<tr>
					<td class="item">비밀번호 확인</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">내 포스팅 공개여부</td>
					<td class="cont">전체공개 <input type="radio" name="open" value="전체공개">
						친구만 공개<input type="radio" name="open" value="친구만 공개"> 비공개<input
						type="radio" name="open" value="비공개">
					</td>
				</tr>
				<tr>
					<td class="item">내 포스팅 댓글 참여 범위</td>
					<td class="cont">전체허용<input type="radio" name="reply" value="전체허용">
						친구만 허용<input type="radio" name="reply" value="친구만 허용"> 허용안함<input
						type="radio" name="reply" value="허용안함">
					</td>
				</tr>
				<tr>
					<td class="item"><input type="submit" value="수정완료""OnClick="javascript:writeCheck();"></td>
					<td class="cont"><input type="submit" value="탈퇴하기" OnClick="javascript:writeCheck();"></td>
				</tr>
			</table>
</form> --%>
<a href = "deleteMember.do">탈퇴하기></a>
</body>
</html>