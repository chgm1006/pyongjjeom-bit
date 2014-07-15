<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:fb="http://ogp.me/ns/fb#">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>===== 평 쩜 =====</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>

<script>
	$(document).ready(function() {

		$("#ajaxTest").click(function() {
			var formData = {
				name : "최경민",
				data : "Hello"
			};

			$.ajax({
				type : "post",
				url : "ajaxTest.do",
				data : JSON.stringify(formData),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				beforeSend : function() {
					console.log(formData);
				},
				error : function(e) {
					console.log(e.responseText);
				},
				success : function(data) {
					$.each(data, function(key) {
						var list = data[key];

						console.log(list);
						for (var i = 0; i < list.length; i++) {
							console.log("val: " + list[i].title);
						}
					});
				}
			});
		});

		$("#FBLogin").click(function() {
			fnLoginFB();
		});

		$("#FBLogout").click(function() {
			fnLogout();
		});
	});
</script>
</head>
<body>
	<div id="fb-root"></div>
	<fb:login-button max_rows="1" size="medium" show_faces="true"
		auto_logout_link="true"></fb:login-button>
	<button type="button" id="FBLogin">페이스북 &nbsp; 로그인</button>
	<button type="button" id="FBLogout">페이스북 &nbsp; 로그아웃</button>
	<input type="button" value="페이스북 친구" onclick="javascript:facebookFriend();">
	<input type="button" value="ajaxTest" id="ajaxTest">
	<br>
	<div id="status"></div>
</body>
</html>