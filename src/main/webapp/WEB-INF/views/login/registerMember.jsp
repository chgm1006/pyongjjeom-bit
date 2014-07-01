
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
<script type="text/javascript"></script>
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
</head>

<body>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="register.force" method="post">
					<h2>
						<span class="red"><strong>평쩜</strong></span>
					</h2>
					<label for="email">Email</label> 
					<input type="text" id="email" name="email" placeholder="enter your email...">
					<label for="name">Name</label>
					<input type="text" id="name" name="memNm" placeholder="enter your name...">
					<label for="birth">Birth</label>
					<input type="text" id="birth" name="birth" placeholder="choose a birth...">
					<label for="password">Password</label>
					<input type="text" id="password" name="passwd" placeholder="enter your password...">
					<label for="password_check">Password Check</label>
					<input type="text" id="password_check" name="password_check" placeholder="enter your passwordcheck...">
					<button type="submit">가입하기</button>
				</form>
			</div>
		</div>
	</div>
</body>


</html>

