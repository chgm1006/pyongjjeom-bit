<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

</head>
<body>
	<div class="login form container">
		<div class="login form">
			<form action="" method="post">
				<h2>
					<span class="red"><strong>로그인</strong></span>
				</h2>
				<label for="login_email">이메일</label> <input type="text" id="login_email"
					name="login_email" placeholder="이메일을 입력하세요.."> <label
					for="login_password">비밀번호</label> <input type="text" id="login_password"
					name="login_password" placeholder="비밀번호를 입력하세요..">
				<button type="submit">로그인</button>
			</form>
			<button type="">비밀번호 찾기</button>
			<button type="">회원가입</button>
			<button type="">페이스북로그인</button>
		</div>
	</div>
</body>
</html>