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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" /></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/loginscripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script type="text/javascript">

	/* $(document)
			.ready(
					function() {
						$("form")
								.submit(
										function() {
											$(this).find("label[for='email']").html('이메일');
											$(this).find("label[for='password']").html('비밀번호');

											var email = $(this).find('input#email').val();
											var password = $(this).find('input#passwd').val();
											var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

											if (email == '') {
												$(this)
														.find("label[for='email']")
														.append(
																"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
												$(this).find("label[for='email'] span")
														.fadeIn('medium');
												$("#email").focus();
												return false;
											} else if (!regEmail.test(email)) {
												$(this)
														.find("label[for='email']")
														.append(
																"<span style='display:none' class='red'> - 이메일 형식에 맞지 않습니다..</span>");
												$(this).find("label[for='email'] span")
														.fadeIn('medium');
												$("#email").focus();
												return false;
											}
											if (password == '') {
												$(this)
														.find("label[for='password']")
														.append(
																"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
												$(this).find("label[for='password'] span").fadeIn(
														'medium');
												$("#passwd").focus();
												return false;
											}

										});
						
						$("#FBLogin").click(function() {
							fnLoginFB();
						});

					}); */
</script>
</head>
<body>



	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="loginsuccess.do" method="post">
					<h2>
						<span class="red"><strong>로그인</strong></span>
					</h2>
					<label for="email">이메일</label> <input type="text" id="email" name="email"
						placeholder="이메일을...."> <label for="password">비밀번호</label> <input
						type="password" id="passwd" name="passwd" placeholder="비밀번호...">
					<button type="submit">로그인</button>
					<button type="button" id="FBLogin">페이스북 로그인</button>

					<!-- <button type="button" id="FBLogin">페이스북 &nbsp; 로그인</button> -->
					<br> <br> <a href="views/">비밀번호를 까먹으셧나영?</a>&nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; <a href="registerMember.do">아직 회원이 아니신가영?</a>
				</form>

			</div>
		</div>
	</div>
</body>
</html>