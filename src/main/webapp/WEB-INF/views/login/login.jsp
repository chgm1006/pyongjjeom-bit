<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!-- CSS -->


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->


<article>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<!--크기 -->
				<form action="loginsuccess.do" method="post">

					<h2>
						<span class="red"><strong>로그인</strong></span>
					</h2>
					<label for="email">이메일</label> <input type="text" id="email" name="email"
						placeholder="이메일을...."> <label for="password">비밀번호</label> <input
						type="password" id="passwd" name="passwd" placeholder="비밀번호...">
					<button type="submit">로그인</button>
					<button type="button" id="FBLogin">페이스북 로그인</button>

					<br> <br> <a href="emailAuth.do">비밀번호를 잊어버리셨나요?</a>&nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; <a href="registerMember.do">아직 회원이 아니신가요?</a>

				</form>

			</div>
		</div>
	</div>
	</article>


<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" /></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/loginscripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#FBLogin").click(function() {
			fnLoginFB();
		});

		$("#FBLogout").click(function() {
			fnLogout();
		});

	});

</script>
</body>
</html>