<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>

<!-- CSS -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=PT+Sans:400,700">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oleo+Script:400,700">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".register form").submit(
						function() {
							$(this).find("label[for='passwd']").html('새 비밀번호');
							$(this).find("label[for='passwdCheck']").html('새 비밀번호 확인');

							var passwd = $(this).find('input#passwd').val();
							var passwdChk = $(this).find('input#passwdCheck').val();
							// 			console.log(passwd);
							// 			console.log(passwdChk);

							if (passwd == "") {
								$(this).find("label[for='passwd']").append(
										"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
								$(this).find("label[for='passwd'] span").fadeIn('medium');
								$("#passwd").focus();
								return false;
							}
							if (passwd != passwdChk) {
								$(this).find("label[for='passwdCheck']").append(
										"<span style='display:none' class='red'> - 비밀번호가 다릅니다..</span>");
								$(this).find("label[for='passwdCheck'] span").fadeIn('medium');
								$("#passwdCheck").focus();
								return false;
							}
						});

			});
</script>
<article>
  <div class="register-container container">
    <div class="row" style="width: 600px; margin: 0 auto;">

      <div class="register span6">
        <form action="movieIndex.do" method="get">
          <h3>
            <span class="red"><strong>비밀번호가 정상적으로 변경되었습니다.</strong></span>
          </h3>
          <!-- 					<label for="passwd">새 비밀번호 &nbsp; &nbsp;</label>  -->
          <!-- 					<input type="password" id="passwd" name="passwd" placeholder="비밀번호"><br>  -->
          <!-- 					<label for="passwdCheck">새 비밀번호 확인 &nbsp; &nbsp;</label>  -->
          <!-- 					<input type="password" id="passwdCheck" name="passwdCheck" placeholder="비밀번호 확인"><br> -->
          <button type="submit" id="btn">로그인화면으로 이동</button>
        </form>
      </div>
    </div>
  </div>
</article>
</body>


</html>

