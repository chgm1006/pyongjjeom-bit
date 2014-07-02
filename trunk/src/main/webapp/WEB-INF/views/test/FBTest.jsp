<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/FBscript.js">
	
</script>
</head>
<body>
	<div id="fb-root"></div>
	<div class="fb-login-button" data-max-rows="1" data-size="medium"
		data-show-faces="true" data-auto-logout-link="true"></div>
	<input type="button" value="페이스북 로그인" onclick="javascript:login();">
	<input type="button" value="페이스북 친구" onclick="javascript:facebookFriend();">
	<div id="friend"></div>
</body>
</html>