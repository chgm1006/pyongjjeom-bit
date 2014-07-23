<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=PT+Sans:400,700">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Oleo+Script:400,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>



<script>
	$(document).ready(function() {

		$("#email").change(function(){
			alert($(this).val());
			console.log($(this).val());
		});
		$('#emailCheck').click(function() {
			
				var email = $("#register #email");
			if ($(email).val() == '') {
				alert("이메일 값을 넣어 주세요");
				return false;
			} else { 

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
							document.register.checkemail.value = 1;
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
<article>

<div class="register-container container">
	<div class="row" style="width:600px; margin:0 auto;">

		<div class="register span6">
			<form id="register" name="register" action="register.do" method="post">
				<h2>
					<span class="red"><strong>평쩜</strong></span>
				</h2>
				
				<table style="margin:0 auto;">
					<tr>
						<td>
											<label for="email" >이메일</label> 
						</td>
						<td>
											<input type="text"  id="email" name="email"	placeholder="이메일..."> 
											<input type="button" id="emailCheck" value="중복확인"><br>
						</td>
					</tr>
					<tr>
						<td>
				<label for="name">이름</label>
							
						</td>
						<td>
				<input type="text"	id="name" name="memNm" placeholder="이름..."> 
							
						</td>
					</tr>
					<tr>
						<td>
				<label for="birth">생년월일</label>
							
						</td>
						<td>
				<input type="text" id="birth" name="birth" placeholder="'-'빼고 숫자만...">
							
						</td>
					</tr>
					<tr>
						<td>
				<label for="password">비밀번호</label> 
							
						</td>
						<td>
				<input type="password" id="password" name="passwd" placeholder="6자~20자..."> 
							
						</td>
					</tr>
					<tr>
						<td>
				<label for="password_check">비밀번호확인</label>
							
						</td>
						<td>
				<input type="password" id="password_check" name="password_check"	placeholder="비밀번호확인...">
							
						</td>
					</tr>
					
				</table>
	
				<button type="submit" id="btn_submit">가입하기</button>
				<button type="button" OnClick="javascript:history.back(-1)">돌아가기</button>
		  
		
			</form>
			
		
		</div>
	</div>
</div>



</article>
</body>


</html>

