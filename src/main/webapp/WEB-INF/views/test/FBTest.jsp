<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
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
				alert("login");
			} else {
				alert("no login");
			}
		}, {
			scope : "publish_stream,offline_access"
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

	function login() {
		FB.login(function(response) {
			if (response.authResponse) {
				alert("login");
			} else {
				alert("no login");
			}
		}, {
			scope : "publish_stream,offline_access"
		});
	}

	function facebookFriend(code, page) {

		var facebook_count = 0;

		FB.api({
			method : 'fql.query',
			query : 'SELECT uid, name, email, birthday, pic_square, online_presence  FROM user WHERE uid IN (SELECT uid2 FROM friend WHERE uid1 = me())'
		},
		function(response) {
			alert(response.length);
			var tmp_str = "";
			for (var i = 0; i < response.length; i++) {
				tmp_str += "<tr>";
				tmp_str += "<td>" + response[i].name + "</td>";
				tmp_str += "<td><img src='"+response[i].pic_square+"' alt='"+response[i].uid+"'></td>";
				tmp_str += "</tr>";
				response[i].uid;
				response[i].birthday;
				response[i].email;
				response[i].online_presence;
			}
			$("#friend").html(tmp_str);
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