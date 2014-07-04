window.fbAsyncInit = function() {
	FB.init({
		appId : '1449705105272003',
		cookie : true, // enable cookies to allow the server to access
		// the session
		xfbml : true, // parse social plugins on this page
		version : 'v2.0' // use version 2.0
	});

	FB.getLoginStatus(function(response) {
		// fnLoginFB(response);
	});

};

// Load the SDK asynchronously
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function fnLoginFB(response) {
	FB.login(function(response) {
		var fbName;
		var accessToken = response.authResponse.accessToken;
		if (response) {
			console.log(response);
			window.location.reload(true);
		}
	}, {
		scope : "publish_stream, user_friends"
	});
}

function facebookFriend(code, page) {
	FB
			.api(
					"/me/taggable_friends",
					function(response) {
						console.log(response.error);
						if (response && !response.error) {
							console.log(response);
							var data = response.data;
							console.log("1111 = " + data.length);
							var friendsList = "<table border='1'>";
							friendsList += "<tr><td>이름</td><td>사진 URL</td><td>is_silhouette</td></tr>";
							for (var i = 0; i < data.length; i++) {
								friendsList += "<tr>";
								friendsList += "<td>" + data[i].name + "</td>";
								friendsList += "<td><img src='" + data[i].picture.data.url + "'/></td>";
								friendsList += "<td>" + data[i].picture.data.is_silhouette + "</td>";
								friendsList += "</tr>";
							}
							friendsList += "</table>";
							$("#status").html(friendsList);
						}
					});
}

function fnLogout() {
	FB.logout(function(response) {

		console.log(response);
		console.log(response.name + "님이 로그아웃 하셨습니다.");
		$("#status").html(response.name + "님이 로그아웃 하셨습니다.");
		// window.location.reload(true);
	});
}
