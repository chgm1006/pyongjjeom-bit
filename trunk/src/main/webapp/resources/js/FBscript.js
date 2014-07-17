var fbUid;
var fbName;
var fbEmail;
var fbBirthday;
var fbIMGURL;
var FB_APPID;

window.fbAsyncInit = function() {
	FB_APPID = "pyongjjeom.com" == location.host ? "682328688505624"
			: "1449705105272003";

	FB.init({
		appId : FB_APPID,
		status : true,
		cookie : true, // enable cookies to allow the server to access
		// the session
		xfbml : true, // parse social plugins on this page
		version : 'v2.0', // use version 2.0
		oauth : true
	});

	// $(document).trigger("FB:init");
	// FB.getLoginStatus(function(response) {
	// if (response.status === "connected") {
	// console.log(response);
	// fnLoginFB(response);
	// } else if (response.status === "not_authorized") {
	//
	// } else {
	// fnLogout(response);
	// }
	// });

	FB.Event.subscribe('auth.login', function(response) {
		console.log(response);
	});

	FB.Event.subscribe('auth.logout', function(response) {
		window.location.reload(true);
	});

	FB.Event.subscribe("xfbml.render", function() {
		return $(document).trigger("FB:xfbml.render");
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
		if (response) {
			FB.api("/me", function(response) {
				fbUid = response.id;
				fbName = response.first_name + " " + response.last_name;
				fbEmail = response.email;
				fbBirthday = StringToDate(response.birthday);
				fbIMGURL = 'http://graph.facebook.com/' + fbUid + '/picture';

				var url = "fbLogin.do";
				ajaxFBRegisterMember(url);

			});
		}
	}, {
		scope : "public_profile, email, user_friends, user_birthday"
	});
}

function ajaxFBRegisterMember(url) {
	var formData = {
		fbId : fbUid,
		memNm : fbName,
		email : fbEmail,
		birth : fbBirthday,
		imgPath : fbIMGURL
	};

	$.ajax({
		type : "post",
		url : url,
		data : JSON.stringify(formData),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		async : false,
		beforeSend : function() {
			console.log(formData);
		},
		error : function(e) {
			console.log(e.responseText);
		},
		success : function(data) {
			console.log("fbLogin 시작");
			if (data == null) {
				alert("회원 정보가 잘못되었습니다.");

			} else {
				$.each(data, function(key) {
					var list = data[key];
					console.log(key + " = " + list);

				});
				console.log("fbLogin 종료");
				window.location.reload(true);
			}

		}

	});

}

function StringToDate(strDate) {
	var dt = strDate.replace(/\//gi, "");
	var year = dt.substring(4);
	var month = dt.substring(0, 2);
	var day = dt.substring(2, 4);
	return year + month + day;
}

function facebookFriend(code, page) {
	FB
			.api(
					"/me/friends",
					function(response) {
						console.log(response.error);
						if (response && !response.error) {
							console.log(response);
							var data = response.data;
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
							$("#status").html(friendsList);
						}
					});
}

function fnLogout() {
	var url = "logout.do";
	console.log("fnLogout");
	$.ajax({
		type : "post",
		url : url,
		async : false,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		error : function(e) {
			console.log(e.responseText);
		},
		success : function(data) {
			console.log("fbLogout 시작");
			console.log(data);
			console.log("fbLogout 종료");
		}
	});

}
