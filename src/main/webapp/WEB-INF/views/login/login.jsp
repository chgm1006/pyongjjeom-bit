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
<script type="text/javascript">
	$(document)
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

						/* $("#FBLogin").click(function() {
							fnLoginFB();
						}); */
					});
</script>
</head>
<body>
	<div id="fb-root"></div>
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '279481992230769', // 앱 ID
				status : true, // 로그인 상태를 확인
				cookie : true, // 쿠키허용
				xfbml : true
			// parse XFBML
			});
			FB.getLoginStatus(function(response) {
				if (response.status === 'connected') {

					FB.api('/me', function(user) {
						if (user) {
							var image = document.getElementById('image');
							image.src = 'http://graph.facebook.com/' + user.id + '/picture';
							var name = document.getElementById('name');
							name.innerHTML = user.name
							var id = document.getElementById('id');
							id.innerHTML = user.id
						}
					});

				} else if (response.status === 'not_authorized') {

				} else {

				}
			});

			FB.Event.subscribe('auth.login', function(response) {
				document.location.reload();
			});
			// 추가적인 코드는 여기에 작성해주세요.
		};
		// Load the SDK Asynchronously
		/* (function(d) {
			var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement('script');
			js.id = id;
			js.async = true;
			js.src = "//connect.facebook.net/ko_KR/all.js#xfbml=1";
			ref.parentNode.insertBefore(js, ref);
		}(document)); */
		(function(d, s, id) {
		  var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
		  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.0";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	

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

					<button type="button" id="FBLogin">페이스북 &nbsp; 로그인</button>
					<br> <br> <a href="views/">비밀번호를 까먹으셧나영?</a>&nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; <a href="registerMember.do">아직 회원이 아니신가영?</a>

				</form>
				<p>로그인버튼</p>
	<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="false">
	<!-- <fb:login-button show-faces="false" width="200" max-rows="1"></fb:login-button> -->
	
	</div>
			</div>
		</div>
	</div>
</body>
</html>