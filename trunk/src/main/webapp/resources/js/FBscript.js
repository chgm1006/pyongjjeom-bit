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
			FB.api('/me/taggable_friends', function(response) {
				console.log(response);
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
	console.log("1111");
	FB.api("/me/taggable_friends", function(response) {
		console.log(response.error);
		if (response && !response.error) {
			console.log(response);
			console.log(response.size);
		}
	});
}