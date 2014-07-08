window.fbAsyncInit = function() {
	FB.init({
		appId : '1449705105272003',
		cookie : true, // enable cookies to allow the server to access
		// the session
		xfbml : true, // parse social plugins on this page
		version : 'v2.0' // use version 2.0
	});

	FB.getLoginStatus(function(response) {
		console.log(response);
		if(response.status === "connected"){
			var uid = response.authResponse.userID;
			var accessToken = response.authResponse.accessToken;
			console.log("uid = " + uid);
			console.log("accessToken = " + accessToken);
		}else if(response.status === "not_authorized"){
			console.log("not login");
		}
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

var fbName;
var fbEmail;

function fnLoginFB(response) {
	FB.login(function(response) {
		if (response) {
			FB.api("/me", function(response) {
				console.log(response);
				console.log(response.first_name + " " + response.last_name);
				console.log(response.email);
				console.log(response.id );
				console.log(StringToDate(response.birthday)  );
				console.log(response.bio  );
				fbName = response.name;
				fbEmail = response.email;
//				$("#status").html(response.name + "님이 로그인 하셨습니다.");
			});
			// window.location.reload(true);
		}
	}, {
		scope : "public_profile, email, user_friends, user_birthday"
	});
}

function StringToDate(strDate){
	var dt = strDate.replace(/\//gi,"");
	var year = dt.substring(4);
	var month = dt.substring(0, 2);
	var day = dt.substring(2, 4);
	return year+month+day;
}

function facebookFriend(code, page) {
	FB.api(
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
					friendsList += "<td><img src='" + data[i].picture.data.url
							+ "'/></td>";
					friendsList += "<td>" + data[i].picture.data.is_silhouette
							+ "</td>";
					friendsList += "</tr>";
				}
				friendsList += "</table>";
//				$("#status").html(friendsList);
			}
		});
}

function fnLogout() {
	FB.logout(function(response) {

		if(response){
//			$("#status").html(fbName + "님이 로그아웃 하셨습니다.");
			console.log(fbName+ "님이 로그아웃 하셨습니다.");
		}
		// window.location.reload(true);
	});
}

$("#FBLogin").click(function(){
	fnLoginFB();
});

$("#FBLogout").click(function(){
	fnLogout();
});
