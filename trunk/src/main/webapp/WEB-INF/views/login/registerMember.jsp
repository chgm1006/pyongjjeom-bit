
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
<script type="text/javascript">

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

<body>

	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="register.do" method="post">
					<h2>
						<span class="red"><strong>평쩜</strong></span>
					</h2>
					<label for="email">이메일</label> 
					<input type="text" id="email" name="email" placeholder="이메일...">
					<label for="name">이름</label>
					<input type="text" id="name" name="memNm" placeholder="이름...">
					<label for="birth">생년월일</label>
					<input type="text" id="birth" name="birth" placeholder="생년월일...">
					<label for="password">비밀번호</label>
					<input type="password" id="password" name="passwd" placeholder="비밀번호...">
					<label for="password_check">비밀번호확인</label>
					<input type="password" id="password_check" name="password_check" placeholder="비밀번호확인...">
					<button type="submit">가입하기</button>
					<button type="button" OnClick="javascript:history.back(-1)">돌아가기</button>
				</form>
			</div>
		</div>
	</div>
</body>


</html>

