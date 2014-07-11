<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>my Room</title>

<link href="${pageContext.request.contextPath}/resources/css/default1.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/myroom.css"
	rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
<script type="text/javascript">
	$(function() {
		$("#upLoadButton,.close").click(function() {
			if ($(".upLoad").css("display") == "block") {
				$(".upLoad:not(:animated)").slideUp("slow");
			} else {
				$(".upLoad").slideDown("slow");
			}
		});
	});
</script>
<script>
	function valueChange() {
		var x = document.getElementById('range');
		var y = document.getElementById('inputValue');
		y.value = x.value;
	}
</script>


<script type="text/javascript">
	$(function() {

		$("#glayLayer2").click(function() {
			$(this).hide()
			$("#overLayer2").hide();
			$("#overLayer3").hide();
		});

		$("#setUpButton").click(function() {
			$("#glayLayer2").show();
			$("#overLayer2").fadeIn("Fast");
			return false;
		});
		$("#setUpButton").click(function() {
			$("#glayLayer2").show();
			$("#overLayer2").fadeIn("Fast");
			return false;
		});
		$(".exit").click(function() {
			$("#glayLayer2").hide()
			$("#overLayer2").hide();
		});

		if ($.browser.msie && $.browser.version < 7) {
			$(window).scroll(
					function() {
						$("#glayLayer2").css('top', $(document).scrollTop());
						$("#overLayer2").css(
								'top',
								($(document).scrollTop() + $("#overLayer2").height() / 2)
										+ "px");
					});
		}
	});
	function button_event(){
		if (confirm("정말 탈퇴하시겠습니까??") == true){    //확인
		    document.location.href = "deleteMember.do";
		}else{   //취소
		    return;
		}
	}
	function button_event1(){
		if (confirm("정말 로그아웃하시겠습니까??") == true){    //확인
		    document.location.href = "logout.do";
		}else{   //취소
		    return;
		}
	}
</script>


<!----------상세 슬라이드 다운---------->
<script type="text/javascript">
	$(function() {
		$("dd").css("display", "none");
		$("dl dt").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$("+dd", this).slideDown("slow");
			} else {
				$("+dd", this).slideUp("slow");
			}
		});
	});
</script>
</head>

<body>

	<div class="myPageWrap">

		<div class="menu">
			<ul>
				<li class="boardMenu"><a class="myPageMenu" id="setUpButton" href="#"
					OnClick="window.location='mySet.do'">설정</a></li>
				<li class="boardMenu"><a class="myPageMenu" id="upLoadButton" href="#">평점올리기</a></li>
				<li class="boardMenu"><a href="logout.do" class="boardMenu_1">로그아웃</a></li>
			</ul>
		</div>
				<input type="button" value="회원탈퇴" onclick="Javascript:button_event();">
				<input type="button" value="로그아웃" onclick="Javascript:button_event1();">
		<div class="upLoad">
			<a href="#" class="close"></a>
			<div class="title2">평점 올리기</div>
			<div class="upLoadSearch">
				<form action="ContentsSearch.do" method="get" id="frmLogin" name="frmLogin">
					<select name="category">
						<option value="book">책
						<option value="movie">영화
					</select>
					 <input type="text" id="Search" name="Search"> <input type="hidden"
						name="stat" value="posting"> <input type="submit" value="검색">
				</form>
			</div>
			<div class="upLoadCont">
				<form action="postingInsert.do" method="post">
				<table>
					<tr>
						<td>나의 평점</td>
							<td><input id="range" type="range" value="0" min="0" step="0.5"
						max="10" list="number" onchange="valueChange();" /> <datalist id="number">
							<option>0</option>
							<option>2</option>
							<option>4</option>
							<option>6</option>
							<option>8</option>
							<option>10</option>
						</datalist> <input id="inputValue" type="text" size="5"  name="memGrade"  /></td>
					</tr>
					<tr>
						<td>나의 한줄평</td>
						<td><input type="text" style="width: 500px" name="comment"></td>
					</tr>
				</table>
				<input type="text" class="upLoadText"  name="review"><br> 
				<input type="hidden"  name="pmemCD" value=${member.memCD }>
					<input type="hidden"  name="title" value="의형제">
							<input type="hidden"  name=director value="장훈">
							<input type="hidden"  name="image" value="http://imgmovie.naver.com/mdi/mit110/0525/52548_P43_123614.jpg">
									<input type="hidden"  name="actor" value="송강호|강동원|">
											<input type="hidden"  name="link" value="http://openapi.naver.com/l?AAADWLywrDIBREv+ZmKaKR6MJFyOM/1FxRSjS1NuDfNwkUhjPMgXl/sTQNywRqBiVheajEbUYKaupqO1Dv+YzYvbBpxzZvpWB8GAxaQ6lEyzz1fsCtF5J3oaDXodYD+AhsvfKcSTInFuLy/jdX23iPG9Z8oiMpJOCryxsCnwUTvfwBScpS06AAAAA=
">
											
				<input type="submit"
					class="upLoadStart" value="글올리기">
					</form>
			</div>

		</div>

		<div class="title2">내가 올린 포스트</div>

		<c:forEach items="${postList}" var="post">
			<div class="postingList">
				<dl>
					<dt class="listHead">

						<div class="list1">
							<a href="#" class="listImgLink"><img src="${post.image} " class="listImg"></a>

							<div class="detail">
								<table>
									<tr>
										<td class="listTitle1" colspan="2">${post.title}</td>
									</tr>
									<tr>
										<td class="listTitle">나의 평점</td>
										<td class="listDirectorValue">${post.memGrade }</td>
									</tr>
									<tr>
										<td class="listTitle">한줄평</td>
										<td class="listActorValue">${post.comment }</td>
									</tr>
									<tr>
										<td class="listTitle">나의 후기</td>
										<td class="listSynopValue">${post.review }</td>
									</tr>
								</table>
								<div class="PostingReply">댓글 2개</div>
								<a href="#"
								OnClick="window.location='updatePost.do?postCD=${post.postCD}'">글수정</a> 
								<a href="#"
								OnClick="window.location='deletePost.do?postCD=${post.postCD}'">삭제</a>
								
							</div>

						</div>
					</dt>
					<dd class="listContent">

						<h3>코멘트</h3>
						<br>
						<div class="commentBox">
							<div class="userPhoto">
								<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>박희본
							</div>
							<div class="triangle"></div>
							<div class="rectangle">
								<h3>나도 이 영화 봤다.</h3>
								<h5>2014.06.19</h5>
							</div>
							<a href="#" class="commentDel">삭제</a>
						</div>
						<div class="clear"></div>
						<div class="commentBox">
							<div class="userPhoto">
								<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>박희본
							</div>
							<div class="triangle"></div>
							<div class="rectangle">
								<h3>나도 이 영화 봤다.</h3>
								<h5>2014.06.19</h5>
							</div>
							<a href="#" class="commentDel">삭제</a>
						</div>
						<div class="clear"></div>
						<a href="#" class="commentMore">더보기</a>
					</dd>
					<dt class="listHead">
		</c:forEach>
		
	<!-- 	<div class="list1">
			<a href="#" class="listImgLink"><img src="img/07.jpg" class="listImg"></a>
			<div class="detail">
				<table>
					<tr>
						<td class="listTitle1" colspan="2">미녀와 야수</td>
					</tr>
					<tr>
						<td class="listTitle">나의 평점</td>
						<td class="listDirectorValue">별표별표</td>
					</tr>
					<tr>
						<td class="listTitle">한줄평</td>
						<td class="listActorValue">이곳은 한줄평입니다.</td>
					</tr>
					<tr>
						<td class="listTitle">나의 후기</td>
						<td class="listSynopValue">가까운 미래, 미믹이라 불리는 외계 종족의 침략으로 인류는 멸망 위기를
							맞는다. 빌 케이지 (톰 크루즈)는 자살 작전이나 다름없는 작전에 훈련이나 장비를 제대로 갖추지 못한 상태로 배정되고 전투에
							참여하자마자 죽음을 맞는다. 하지만 불가능한 일이 일어난다. 그가 다시 그 끔찍한 날이 시작된 시간에 다시 깨어나 다시 전투에
							참여하게 되고 다시 죽었다가 또 다시 살아나는 것. 외계인과의 접촉으로 같은 시간대를 반복해서 겪게 되는 타임 루프에 갇히게 된
							것이다.</td>
					</tr>
				</table>
				<div class="PostingReply">댓글 2개</div>
			</div>

		</div>
		</dt>
		<dd class="listContent">

			<h3>코멘트</h3>
			<br>
			<div class="commentBox">
				<div class="userPhoto">
					<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>박희본
				</div>
				<div class="triangle"></div>
				<div class="rectangle">
					<h3>나도 이 영화 봤다.</h3>
					<h5>2014.06.19</h5>
				</div>
				<a href="#" class="commentDel">삭제</a>
			</div>
			<div class="clear"></div>

			<a href="#" class="commentMore">더보기</a>
		</dd>
		</dl>
	</div>

	<a href="#" class="listMore">더보기</a>

	</div> -->



	<!-- <div id='glayLayer2'></div>
	<div id='overLayer2'>

		<a href="#" class="exit"></a>
		<form name=setupFirm method=POST action="setEdit.do">
		<div class="setUp">
			<table>
				<tr>
					<td class="item">이름</td>
					<td class="cont"><input type="text" placeholder = 'a'></td>
				</tr>
				<tr>
					<td class="item">이메일</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">생년월일</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">패스워드</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">패스워드 확인</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">내 포스팅 공개여부</td>
					<td class="cont">전체공개 <input type="radio" name="open" value="전체공개">
						친구만 공개<input type="radio" name="open" value="친구만 공개"> 비공개<input
						type="radio" name="open" value="비공개">
					</td>
				</tr>
				<tr>
					<td class="item">내 포스팅 댓글 참여 범위</td>
					<td class="cont">전체허용<input type="radio" name="reply" value="전체허용">
						친구만 허용<input type="radio" name="reply" value="친구만 허용"> 허용안함<input
						type="radio" name="reply" value="허용안함">
					</td>
				</tr>
				<tr>
					<td class="item"><input type="submit" value="수정완료"></td>
					<td class="cont"><input type="submit" value="탈퇴하기"></td>
				</tr>
			</table>


		</div>

	</div>


 -->
</body>
</html>
