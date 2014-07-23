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

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		$('.register form').submit(function() {
			$(this).find("label[for='emailAuthCD']").html('인증번호');
			var emailAuthCD = $(this).find('input#emailAuthCD').val();
			if (emailAuthCD == '') {
				$(this)
						.find("label[for='emailAuthCD']")
						.append(
								"<span style='display:none' class='red'> - 인증번호를 입력하세요</span>");
				$(this).find("label[for='emailAuthCD'] span")
						.fadeIn('medium');
				$("#emailAuthCD").focus();
				return false;
			}
			if (!checkAuthCD(emailAuthCD)) {
				$(this)
						.find("label[for='emailAuthCD']")
						.append(
								"<span style='display:none' class='red'> - 인증번호를 확인하세요</span>");
				$(this).find("label[for='emailAuthCD'] span")
						.fadeIn('medium');
				$("#emailAuthCD").val("").focus();
				return false;
			}
			
		});
		function checkAuthCD(emailStr) {
			return emailStr.match(/[0-9 -()+]+$/);
		}
	});
</script>

<article>
	<div class="register-container container">
		<div class="row"  style="width:600px; margin:0 auto;">

			<div class="register span6">
				<form action="emailAuth_check.do" method="post">
					<h2>
						<span class="red"><strong>인증번호 입력</strong></span>
					</h2>
					<label for="emailAuthCD">인증번호가 회원님의 이메일로 발송 되었습니다. <br>이메일을 확인해 주세요. &nbsp; &nbsp; <span class="red">${errorMSG }</span></label>
					<input type="text" id="emailAuthCD" name="emailAuthCD"
						placeholder="인증번호를 입력하세요...."><br>

					<button type="submit">인증번호확인</button>
					<input type="hidden" id="email" name="email" value="${member.email }">
				</form>
			</div>
		</div>
	</div>
</article>
</body>


</html>

