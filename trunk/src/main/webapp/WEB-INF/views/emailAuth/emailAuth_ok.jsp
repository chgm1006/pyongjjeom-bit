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

<article>
	<div class="register-container container">
		<div class="row" style="width:600px; margin:0 auto;">

			<div class="register span6">
				<form action="goChangePasswd.do" method="post">
					<h3>
						<span class="red"><strong>인증이 완료되었습니다</strong></span>
					</h3>
					<input type="hidden" id="email" name="email" value="${email }">
					<button type="submit" id="btn">비밀번호 변경</button>
				</form>
			</div>
		</div>
	</div>
</article>
</body>


</html>

