<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
	userId = "";

	window.fbAsyncInit = function() {
		FB.init({
			appId : '1449705105272003',
			xfbml : true,
			oauth : true,
			status : true,
			cookie : true
		});

		FB.login(function(response) {
			if (response.authResponse) {
				console.log(response.authResponse.accessToken);
				console.log(response.authResponse.userID);
				console.log(response.name);
				var accessToken = response.authResponse.accessToken;
				FB.api('/me/friends/?limit=0', function(user) {
					console.log(user);
				});
			} else {
				alert("no login");
			}
		}, {
			scope : "publish_actions,user_friends"
		});
	};

	(function(d) {
		var js, id = 'facebook-jssdk';
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement('script');
		js.id = id;
		js.async = true;
		js.src = "//connect.facebook.net/ko_KR/all.js";
		d.getElementsByTagName('head')[0].appendChild(js);
	}(document));

	function facebookFriend(code, page) {

		var facebook_count = 0;

		console.log("1111");
		FB.api("/me/members/", function(response) {
			if (response && !response.error) {
				console.log(response);
			}
		});
	}
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