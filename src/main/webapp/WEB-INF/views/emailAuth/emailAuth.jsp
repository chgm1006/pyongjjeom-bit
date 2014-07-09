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

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript">
	jQuery(document)
			.ready(
					function() {
						/*
						 * Form validation
						 */
						$('.register form')
								.submit(
										function() {
											$(this).find("label[for='email']").html('Email');
											var email = $(this).find('input#email').val();
											if (email == '') {
												$(this)
														.find("label[for='email']")
														.append(
																"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
												$(this).find("label[for='email'] span")
														.fadeIn('medium');
												$("#email").focus();
												return false;
											}
											if (!checkEmail(email)) {
												$(this)
														.find("label[for='email']")
														.append(
																"<span style='display:none' class='red'> - 이메일 형식에 맞지 않습니다.</span>");
												$(this).find("label[for='email'] span")
														.fadeIn('medium');
												
												$("#email").val("").focus();
												return false;
											}
										});

						function checkEmail(emailStr) {
							return emailStr.match(/\w+[/\w.]*@[/\w.]+\.\w+/);
						}
					});
</script>
</head>

<body>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="emailAuth_sendCD.do" method="post">
					<h2>
						<span class="red"><strong>이메일 인증</strong></span>
					</h2>
					<label for="email">Email</label> <input type="text" id="email" name="email"
						placeholder="이메일을 입력하세요...">
					<button type="submit">인증메일발송</button>
				</form>
			</div>
		</div>
	</div>

</body>


</html>

