<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>PJ main</title>
<link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/resources/img/logo.ico">

<!---- CSS : Header ---->
<link href="${pageContext.request.contextPath}/resources/css/header.css"
	rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<!---- CSS : Footer ---->
<link href="${pageContext.request.contextPath}/resources/css/footer.css"
	rel="stylesheet" type="text/css">
	
<script src="${pageContext.request.contextPath}/resources/js/scrollBanner2.js"></script>

<!---- jQuery : 메인로고, 마이룸, 공지사항 RollOver ---->
<script>
	$(document).ready(function(){
		$(".performanceButton").mouseenter(function(){
			$(".performanceHidden").show();
			$(".performanceButton").css("border-top","4px solid #8dc63f");	
		});
		$(".performanceButton").mouseleave(function(){
			$(".performanceHidden").hide();
			$(".performanceButton").css("border-top","4px solid #f4f4f4");	
		});
		$(".menu5_1,.loginHidden").mouseenter(function(){
			$(".loginHidden").show();
			$(".menu5_1").css("border","2px solid #fea915"); 
			$(".menu5_1").css("background-color","#ffe4b5");

		});
		$(".menu5_1,.loginHidden").mouseleave(function(){
			$(".loginHidden").hide();
			$(".menu5_1").css("border","2px solid #f4f4f4");
			$(".menu5_1").css("background-color","");
		});
		$(".notLogin,.loginHidden2").mouseenter(function(){
			$(".loginHidden2").show();
		});
		$(".notLogin,.loginHidden2").mouseleave(function(){
			$(".loginHidden2").hide();
		});
		$(".menu5a_1,.myRoomHidden").mouseenter(function(){
			$(".myRoomHidden").show();
			$(".menu5a_1").css("border","2px solid #fea915");
			$(".menu5a_1").css("background-color","#ffe4b5");

		});
		$(".menu5a_1,.myRoomHidden").mouseleave(function(){
			$(".myRoomHidden").hide();
			$(".menu5a_1").css("border","2px solid #f4f4f4");
			$(".menu5a_1").css("background-color","");
		});
		$(".menu7_1,.boardHidden").mouseenter(function(){
			$(".boardHidden").show();
			$(".menu7_1").css("border","2px solid #fea915");
			$(".menu7_1").css("background-color","#ffe4b5");

		});
		$(".menu7_1,.boardHidden").mouseleave(function(){
			$(".boardHidden").hide();
			$(".menu7_1").css("border","2px solid #f4f4f4");
			$(".menu7_1").css("background-color","");
		});
	});
	
</script>

</head>
<body>
<header>

	<div class="topMenu">
		<a  class="logo"  href="movieIndex.do"></a>
		<div class="leftMenu">
			<ul>
				<li class="menu1"><a href="movieIndex.do">영화</a></li>
				<li class="menu2"><a href="bookIndex.do">도서</a></li>
				<li class="menu3">
					<a class="performanceButton" href="#">공연</a>
					<div class="performanceHidden">
						<img src="${pageContext.request.contextPath}/resources/img/prepare.png">
					</div>
				</li>
			</ul>
			<div class="search">
				<form action="ContentsSearch.do" method="get" id="frmLogin"
					name="frmLogin">
					<select name="category">
						<option value="movie">영화
						<option value="book">책
					</select> 
					<input type="text" id="Search" name="Search"> <input type="hidden"
						name="stat" value="search"> <input type="submit" value="검색">
					<a href="#"> <img class="magnifier"
						src="${pageContext.request.contextPath}/resources/img/magnifier.png">
					</a>
				</form>
			</div>
		</div>

		<div class="rightMenu">
			<ul>
				<c:choose>
					<c:when test="${member==null}">
						<li class="menu5">
							<a href="login.do" class="menu5_1">로그인</a>
								<div class="loginHidden">
									<form action="loginsuccess.do" method="post">
										<h2>로그인</h2>
										<table class="loginBox">
											<tr>
												<td class="loginBoxTd1"><label for="email">e-메일</label></td>
												<td class="loginBoxTd2"><input type="text" id="email" name="email" placeholder="이메일을...."></td>
											</tr>
											<tr>
												<td class="loginBoxTd1"><label for="password">비밀번호</label></td>
												<td class="loginBoxTd2"><input type="password" id="passwd" name="passwd" placeholder="비밀번호..."></td>
											</tr>
										</table>
										<div class="loginButtonWrap">
											<button type="submit" class="loginButton" href="loginsuccess.do">로그인</button>
											<button type="button" class="loginButton"  id="FBLogin" href="loginsuccess.do">페이스북 로그인</button>
										</div>
										<div class="loginElseWrap">
											<a class="loginElse" href="emailAuth.do">비밀번호를 잊어버리셨나요?</a><br>
											<a class="loginElse" href="registerMember.do">아직 회원이 아니신가요?</a>
										</div>
									</form>
								</div>
							</li>
						
					</c:when>
					<c:otherwise>
						<li class="menu5a">
							<a href="myRoom.do" class="menu5a_1">마이룸</a>
							<div class="myRoomHidden">
								<a class="myRoomSub" href="">My 평점</a><br>
								<a class="myRoomSub" href="logout.do">로그아웃</a><br>
								<a class="myRoomSub" href="">설정</a><br>
							</div>
						</li>
					</c:otherwise>
				</c:choose>
				<li class="menu6"><a href="#" class="menu6_1">친구들</a></li>
				<li class="menu7">
					<a href="boardList.do" class="menu7_1">공지사항</a>
					<div class="boardHidden">
								<a class="boardSub" href="">전체보기</a><br>
								<a class="boardSub" href="">행사보기</a><br>
								<a class="boardSub" href="">시스템공지</a><br>
					</div>
				</li>

			</ul>
		</div>
	</div>
</header>


