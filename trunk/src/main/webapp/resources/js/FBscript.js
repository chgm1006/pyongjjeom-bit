window.fbAsyncInit = function() {
	FB.init({
		appId : '1449705105272003',
		xfbml : true,
		oauth : true,
		status : true,
		cookie : true
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

function fnLoginFB() {
	FB.login(function(response) {
		if (response) {
			console.log(response.name);
			console.log(response.authResponse.userID);
			var accessToken = response.authResponse.accessToken;
		} else {
			alert("no login");
		}
	}, {
		scope : "publish_stream,user_likes"
	});
}
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
