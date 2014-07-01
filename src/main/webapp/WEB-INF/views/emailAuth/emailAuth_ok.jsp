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
</head>

<body>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="${pageContext.request.contextPath}/index.jsp" method="get">
					<h3>
						<span class="red"><strong>인증이 완료되었습니다</strong></span>
					</h3>
					<button type="submit" id="btn">로그인</button>
				</form>
			</div>
		</div>
	</div>

</body>


</html>

