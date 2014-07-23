var fbUid;
var fbName;
var fbEmail;
var fbBirthday;
var fbIMGURL;
var FB_APPID;
var FB_link_url;
var FB_accessToken;

window.fbAsyncInit = function() {
	FB_APPID = "pyongjjeom.com" == location.host ? "682328688505624"
			: "1449705105272003";
	FB_link_url = "pyongjjeom.com" == location.host ? location.host
			: "localhost:8080/pyongjjeom";

	console.log("host = " + (location.host));
	console.log("FB_APPID = " + (FB_APPID));
	console.log("FB_link_url = " + (FB_link_url));
	FB.init({
		appId : FB_APPID,
		status : true,
		cookie : true, // enable cookies to allow the server to access
		// the session
		xfbml : true, // parse social plugins on this page
		version : 'v2.0', // use version 2.0
		oauth : true
	});

	// FB.getLoginStatus(function(response) {
	// if (response.status === "connected") {
	// FB_accessToken = response.authResponse.accessToken;
	// console.log(response.authResponse.accessToken);
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
	FB
			.login(
					function(response) {
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
					},
					{
						scope : "public_profile, email, user_friends, user_birthday, manage_friendlists"
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

function fnInviteFriends(code, page) {
	FB.ui({
		method : 'apprequests',
		message : '자네도 평쩜에 참여해보지 않겠나???'
	// filters:["app_non_users"]
	}, function(response) {
		console.log(response);
		var data = $.parseJSON(response.e2e);
		console.log(data.submit_0);
	});
}

function fnLogout() {
	var url = "logout.do";
	$(location).attr("href", url);
}
