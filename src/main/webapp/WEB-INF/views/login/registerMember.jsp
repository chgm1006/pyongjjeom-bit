
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>



<script>
	$(document).ready(function() {

		$('#emailCheck').click(function() {
			if ($('#email').val() == '') {
				alert("이메일 값을 넣어 주세요");
				return false;
			} else {
				var email = $('#email').serialize();

				$.ajax({
					cache : false, // cache가 남아 있지 않게 false
					async : false, // 순차적으로(동기방식) 동작한다.
					type : 'POST', // 포스트방식
					url : 'ajaxLoginCheck.do', // 요청처리
					data : email, // 파라미터
					dataType : 'xml', // 처리한 요청을 받는 형식
					error : function(e) {
						alert("에러 : 데이터가 안넘어갑니다.");
						alert(e.responseText);
					},
					success : function(xml) { // 성공시 해당함수 실행
						var result = $(xml).find('check').text();

						if (result.trim() == 'fail') {
							alert("이 아이디는 사용가능합니다");
							$('#email').show();
							$('#register').submit();
							document.register.checkemail.value=1;
							return true;
						} else if (result.trim() == 'true') {
							alert("아이디가 존재합니다.");
							return false;
						}
					}
				});
			}
		});

	});
</script>



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

</head>
<div class="register-container container">
	<div class="row">

		<div class="register span6">
			<form id="register" name="register" action="register.do" method="post">
				<h2>
					<span class="red"><strong>평쩜</strong></span>
				</h2>
				<input type="hidden" id="checkemail" name="checkemail" value='0' /> <label
					for="email">이메일</label> <input type="text" id="email" name="email"
					placeholder="이메일..."> 
					<input type="button" value="중복확인" id="emailCheck"> 
					<label for="name">이름</label> <input type="text"
					id="name" name="memNm" placeholder="이름..."> <label for="birth">생년월일</label>
				<input type="text" id="birth" name="birth" placeholder="'-'빼고 숫자만..."> <label
					for="password">비밀번호</label> <input type="password" id="password"
					name="passwd" placeholder="6자~20자..."> <label for="password_check">비밀번호확인</label>
				<input type="password" id="password_check" name="password_check"
					placeholder="비밀번호확인...">
	
				<button type="submit" id="btn_submit">가입하기</button>
				<button type="button" OnClick="javascript:history.back(-1)">돌아가기</button>
		    <button type="button" OnClick="window.location='uploadFile.do'">파일업로드</button>
		
			</form>
			
		
		</div>
	</div>
</div>




</body>


</html>

