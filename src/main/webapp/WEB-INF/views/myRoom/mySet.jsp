<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>===== 평 쩜 =====</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


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

<!-- Javascript -->

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>

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
$(document).ready(function(){
		$("#birth").datepicker(
				{
					dateFormat : 'yymmdd',
					prevText : '이전 달',
					changeYear : true,
					changeMonth : true,
					nextText : '다음달',
					yearRange : '-100y',
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					showAnim : "slide", // 애니메이션을 적용한다.
					yearSuffix : '년',
					showAnim : 'slideDown',
				});

		$('.links a.home').tooltip();
		$('.links a.blog').tooltip();

	$('.register form')
	.submit(
			function() {
				
				$(this).find("label[for='email']").html('이메일');
				$(this).find("label[for='name']").html('이름');
				$(this).find("label[for='birth']").html('생년월일');
				$(this).find("label[for='password']").html('비밀번호');
				$(this).find("label[for='password_check']").html('비밀번호확인');
				
				// //
				var email = $(this).find('input#email').val();
				var name = $(this).find('input#name').val();
				var birth = $(this).find('input#birth').val();
				var password = $(this).find('input#password').val();
				var password_check = $(this).find('input#password_check')
						.val();
				// 이메일 유효성 검사
				var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
				// 이름 유효성 검사
				var regName = /^[가-힣]+$/;
				// 생일 유효성 검사
				var regBirth = /^[0-9]+$/;
// 				console.log("1111");
// 				return false;
				if (email == '') {
					$(this)
							.find("label[for='email']")
							.append(
									"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
					$(this).find("label[for='email'] span").fadeIn('medium');
					return false;
				} else if (!regEmail.test(email)) {
					$(this)
							.find("label[for='email']")
							.append(
									"<span style='display:none' class='red'> - 이메일 형식에 맞지 않습니다..</span>");
					$(this).find("label[for='email'] span").fadeIn('medium');
					return false;
				}
				
				if (name == '') {
					$(this)
							.find("label[for='name']")
							.append(
									"<span style='display:none' class='red'> - 이름을 입력하세요.</span>");
					$(this).find("label[for='name'] span").fadeIn('medium');
					return false;
				} else if (!regName.test(name)) {
					$(this)
							.find("label[for='name']")
							.append(
									"<span style='display:none' class='red'> - 한글로 2글자 이상 입력하세요.</span>");
					$(this).find("label[for='name'] span").fadeIn('medium');
					return false;
				}

				if (birth == '') {
					$(this)
							.find("label[for='birth']")
							.append(
									"<span style='display:none' class='red'> - 생일입력.</span>");
					$(this).find("label[for='birth'] span").fadeIn('medium');
					return false;
				} else if (!regBirth.test(birth)) {
					$(this)
							.find("label[for='birth']")
							.append(
									"<span style='display:none' class='red'> - 숫자 이외의 문자가 들어갔습니다.</span>");
					$(this).find("label[for='birth'] span").fadeIn('medium');
					return false;
				}
				if (password == '') {
					$(this)
							.find("label[for='password']")
							.append(
									"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
					$(this).find("label[for='password'] span").fadeIn(
							'medium');
					return false;
				}
				if(password.length < 6 || password.length > 20){
					$(this)
					.find("label[for='password']")
					.append(
							"<span style='display:none' class='red'> - 영문/숫자 조합해서 6자에서 20자이내로 설정해주세요.</span>");
			$(this).find("label[for='password'] span").fadeIn(
					'medium');
			return false;
				}
				if (password_check == '') {
					$(this)
							.find("label[for='password_check']")
							.append(
									"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
					$(this).find("label[for='password_check'] span").fadeIn(
							'medium');
					return false;
				} else if (password_check != password) {
					$(this)
							.find("label[for='password_check']")
							.append(
									"<span style='display:none' class='red'> - 비밀번호가 틀립니다.</span>");
					$(this).find("label[for='password_check'] span").fadeIn(
							'medium');
					return false;
				}
			});
});
</script>


</head>





<body>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form id="register" name="register" action="upDateMySet.do" method="post" enctype="multipart/form-data">
					<h2>
						<span class="red"><strong>평쩜</strong></span>
					</h2>
					
					<label for="fileData" id="fileData">File</label><br/>
          <input id="fileData" name="fileData" type="file"/>
          
					<input type="hidden" name="memCD" value="${member.memCD}"> 
					<input type="hidden" name="email" value="${member.email}"> 
					
					<label for="email">이메일</label> 
					<input type="text" id="email" value="${member.email}" disabled="disabled"> 
					
					<label for="name">이름</label> 
					<input type="text" id="name" name="memNm" value="${member.memNm}"> 
					
					<label for="birth">생년월일</label> 
					<input type="text" id="birth" name="birth" value="${member.birth}"> 
					
					<label for="password">비밀번호</label> 
					<input type="password" id="password" name="passwd" placeholder="비밀번호...">
					
					<label for="password_check">비밀번호확인</label> 
					<input type="password" id="password_check" name="password_check" placeholder="비밀번호확인...">




					<table>
						<tr>
							<td class="item">내 포스팅 공개여부</td>
							<td class="cont">전체공개<input type="radio" name="commOpenChk"
								value="A" <c:if test="${commOpenChk eq 'A'}"> checked="checked"</c:if>>
								친구만 공개<input type="radio" name="commOpenChk" value="F"
								<c:if test="${commOpenChk eq 'F'}"> checked="checked"</c:if>>
								비공개<input type="radio" name="commOpenChk" value="N"
								<c:if test="${commOpenChk eq 'N'}"> checked="checked"</c:if>>
							</td>
						</tr>
						<tr>
							<td class="item">내 포스팅 댓글 참여 범위</td>
							<td class="cont">전체허용<input type="radio" name="commReplyChk"
								checked="checked" value="A"
								<c:if test="${commReplyChk eq 'A'}"> checked="checked"</c:if>>
								친구만 허용<input type="radio" name="commReplyChk" value="F"
								<c:if test="${commReplyChk eq 'F'}"> checked="checked"</c:if>>
								허용안함<input type="radio" name="commReplyChk" value="N"
								<c:if test="${commReplyChk eq 'N'}"> checked="checked"</c:if>></td>
						</tr>

					</table>

					<!-- <label for="email">파일업로드</label> <input type = "hidden" path="name" id="name"></input>
					<input path="fileData" id="fileData" type="file">File</input> <input
						type="submit" />



 -->


					<button type="submit">수정하기</button>
					<button type="button" OnClick="javascript:history.back(-1)">돌아가기</button>
					<button type="button" OnClick="window.location='uploadFile.do'">파일업로드</button>
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
</body>
</html>