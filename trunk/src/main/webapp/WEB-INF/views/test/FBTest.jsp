<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '1449705105272003',
			xfbml : true,
			version : 'v2.0',
			status : true,
			cookie : true
		});
		// 		FB.login(function(response) {
		// 			if (response.authResponse) {
		// 				FB.api('/me', function(response) {
		// 					alert('Good to see you, ' + response.name + '.');
		// 				});
		// 			} else {
		// 				alert('User cancelled login or did not fully authorize.');
		// 			}
		// 		});
		// 		FB.logout(function(response) {
		// 			if (response.authResponse) {
		// 				FB.api('/me', function(response) {
		// 					alert('Good bye, ' + response.name + '.');
		// 				});
		// 			} else {
		// 				alert('User cancelled login or did not fully authorize.');
		// 			}
		// 		});
		FB.getLoginStatus(handleSessionResponse);
		function handleSessionResponse(response) {
			if (response.session) {
				//
				console.log("uid = " + response.uid);
			} else {
				alert("111");
				FB.api('/me', {
					fields : 'last_name'
				}, function(response) {
					console.log(response.message);
				});
			}
		}
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/ko_KR/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
</head>
<body>
	<div id="fb-root"></div>
	<div class="fb-login-button" data-max-rows="1" data-size="medium"
		data-show-faces="false" data-auto-logout-link="true"></div>
</body>
</html>