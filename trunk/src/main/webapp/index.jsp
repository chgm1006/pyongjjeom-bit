<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>PJ main</title>

<!-- /// <head> INCLUDE /// -->
<%@ include file="WEB-INF/views/common/header.jsp"%>

<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/imageSlider.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css"
	rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


</head>

<body>

현재 사용 X 입니다. 

<%-- 
	<!-- ########################################### -->
	<!-- #################    탑   메  뉴     ################# -->
	<!-- ########################################### -->

	<!-- /// <head> INCLUDE /// -->
	<%@ include file="WEB-INF/views/common/header2.jsp"%>


	<article>
		<div class="wrapper">
			<div class="title1">현재 상영 영화</div>

			<!---- 왼쪽 화살표 ---->
			<div class="arrow1">
				<a id="prev3" class="prev" href="#"></a>
			</div>

			<!-- ########################################### -->
			<!-- #################  슬라이드 시작  ################# -->
			<!-- ########################################### -->
			<div class="list_carousel">
				<ul id="foo3">
						<li class="liList"><a class="imgLink" href="#"> <img
							class="imgList"
							src="${pageContext.request.contextPath}/resources/img/06.jpg" />
							<div class="innerOver2">c</div>
							<div class="innerOver">
								영화제목1<br> 감독<br> 출연<br>
							</div>
					</a></li>
					<li class="liList"><a class="imgLink" href="#"> <img
							class="imgList"
							src="${pageContext.request.contextPath}/resources/img/06.jpg" />
							<div class="innerOver2">c</div>
							<div class="innerOver">
								영화제목1<br> 감독<br> 출연<br>
							</div>
					</a></li>
					<li class="liList"><a class="imgLink" href="#"> <img
							class="imgList"
							src="${pageContext.request.contextPath}/resources/img/06.jpg" />
							<div class="innerOver2">c</div>
							<div class="innerOver">
								영화제목1<br> 감독<br> 출연<br>
							</div>
					</a></li>
					<li class="liList"><a class="imgLink" href="#"> <img
							class="imgList"
							src="${pageContext.request.contextPath}/resources/img/06.jpg" />
							<div class="innerOver2">c</div>
							<div class="innerOver">
								영화제목1<br> 감독<br> 출연<br>
							</div>
					</a></li>
					<li class="liList"><a class="imgLink" href="#"> <img
							class="imgList"
							src="${pageContext.request.contextPath}/resources/img/07.jpg" />
							<div class="innerOver2">c</div>
							<div class="innerOver">
								영화제목1<br> 감독<br> 출연<br>
							</div>
					</a></li>
					<c:forEach items="${movieList }" var="movie" varStatus="status">
						<li class="liList"><a class="imgLink" href="#"> <img
								class="imgList" src="${movie.poster}" />
								<div class="innerOver2">c</div>
								<div class="innerOver">
									영화제목 : ${movie.title }<br> 감독 : ${movie.director}<br> 출연 : ${movie.actor }<br>
								</div>
						</a></li>
					</c:forEach>

				</ul>
			</div>
			<!---- 오른쪽 화살표 ---->
			<div class="arrow2">
				<a id="next3" class="next" href="#"></a>
			</div>
		</div>

		<!-- ########################################### -->
		<!-- #################  하단 리스트 시작  ################# -->
		<!-- ########################################### -->
		<div class="contentsList">
			<div class="title2">영화 리스트</div>

			<!------------------- 리스트 첫번째 -------------------->
			<div class="list1">
				<a href="#" class="listImgLink"><img
					src="${pageContext.request.contextPath}/resources/img/06.jpg"
					class="listImg"></a>
				<div class="detail">
					<table>
						<tr>
							<td class="listTitle1" colspan="2">그레이스 오브 모나코</td>
						</tr>
						<tr>
							<td class="listTitle">감독</td>
							<td class="listDirectorValue">니콜라스케이지</td>
						</tr>
						<tr>
							<td class="listTitle">출연</td>
							<td class="listActorValue">니콜키드먼 니콜라스케이지 휴잭맨 도나바니</td>
						</tr>
						<tr>
							<td class="listTitle">줄거리</td>
							<td class="listSynopValue">가까운 미래, 미믹이라 불리는 외계 종족의 침략으로 인류는 멸망 위기를
								맞는다. 빌 케이지 (톰 크루즈)는 자살 작전이나 다름없는 작전에 훈련이나 장비를 제대로 갖추지 못한 상태로 배정되고 전투에
								참여하자마자 죽음을 맞는다. 하지만 불가능한 일이 일어난다. 그가 다시 그 끔찍한 날이 시작된 시간에 다시 깨어나 다시 전투에
								참여하게 되고 다시 죽었다가 또 다시 살아나는 것. 외계인과의 접촉으로 같은 시간대를 반복해서 겪게 되는 타임 루프에 갇히게 된
								것이다.</td>
						</tr>
					</table>
					<div class="listButton">
						<a class="listButtonAll" href="http://naver.com">네이버 상세</a> <a
							class="listButtonAll" href="#">다음 상세</a> <a class="listButtonAll"
							href="#">예고편보기</a> <a class="listButtonAll" href="#">포토보기</a>
					</div>
				</div>
			</div>


			<c:forEach var="movie" items="${movieList }" varStatus="status">
				<div class="list1" onclick="document.location='currentMovieContext.do?num=${status.index}' ">
					<a href="#" class="listImgLink"><img   src="${movie.image}"
						class="listImg"></a>
					<div class="detail">
						<table>
							<tr>
								<td class="listTitle1" colspan="2">${movie.title }</td>
							</tr>
							<tr>
								<td class="listTitle">부제</td>
								<td class="listSynopValue">${movie.subtitle }</td>
							</tr>
							<tr>
								<td class="listTitle">감독</td>
								<td class="listDirectorValue">${movie.director }</td>
							</tr>
							<tr>
								<td class="listTitle">출연</td>
								<td class="listActorValue">${movie.actor }</td>
							</tr>
							<tr>
								<td class="listTitle">개봉년도</td>
								<td class="listSynopValue">${movie.pubDate }</td>
							</tr>

							<tr>
								<td class="listTitle">네이버평점</td>
								<td class="listSynopValue">${movie.userRating }</td>
							</tr>
						</table>
						<div class="listButton">
							<a class="listButtonAll" href="${movie.link }">네이버 상세</a> <a
								class="listButtonAll" href="#">다음 상세</a> <a class="listButtonAll"
								href="#">예고편보기</a> <a class="listButtonAll" href="#">포토보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
			<!------------------- 더보기 버튼 -------------------->
			<a href="#" class="listMore">더보기</a>
		</div>

	</article>


	<!-- ########################################### -->
	<!-- #################    FOOTER    ################# -->
	<!-- ########################################### -->
	<footer>
		<h1>Spring 3, MVC Examples</h1>
		<ul>
			<!-- 			<li><a href="search1.jsp">검색(Naver API)</a></li> 
header 에 구현 
-->

			<li><a href="search2.jsp">포스팅 (NAVER API)</a></li>
			<li><a href="boardList.do">공지사항</a></li>
			<li><a href="MovieDataUpdate.do">영화 평점 DB_INSERT/UPDATE</a></li>
			<li><a href="BookDateUpdate.do">책 평점 DB_INSERT/UPDATE</a></li>
			<li><a href="FBTest.do">FaceBook Test</a></li>
			<li><a href="views/registerMember.do">회원가입</a></li>
			<li><a href="views/emailAuth.do">인증코드 메일보내기</a></li>
			<li><a href="views/login.do">로그인</a></li>
			<li><a href="views/myRoom.do">로그인</a></li>
		</ul>
	</footer>


	<!-- ################################################# -->
	<!-- #################    모달윈도우 : 영화상세    ################# -->
	<!-- ################################################# -->

	<!---- 검은 바탕 ---->
	<div id='glayLayer'></div>

	<!---- above page 시작 ---->
	<div id='overLayer'>

		<!---- 큰 포스터 JPG ---->
		<div class="overTitle">
			<a href="#" class="exit"></a> <img
				src="${pageContext.request.contextPath}/resources/img/06.jpg">
		</div>

		<!---- 작은 포스터 JPG + 평균평점 ---->
		<div class="overCont">
			<div class="overContDetail">
				<img src="${pageContext.request.contextPath}/resources/img/06.jpg"
					class="overContDetailImg">
				<div class="overContDetailText">
					평균평점 : 7.5<img src="img/bigstar.png">
				</div>
			</div>

			<!---- 하단 상세 설명 ---->
			<div class="overContSpec">
				<table class="overContSpecTable">
					<tr>
						<td><h1>그레이스 오브 모나코</h1></td>
					</tr>
					<tr>
						<td><h3>감독</h3></td>
						<td><h3>감독이다.</h3></td>
					</tr>
					<tr>
						<td><h3>출연</h3></td>
						<td><h3>출연이다.</h3></td>
					</tr>

					<tr>
						<td>네이버 평점</td>
						<td>7.2</td>
						<td>다음 평점</td>
						<td>8.5</td>
					</tr>
					<tr>
						<td>CGV</td>
						<td>7.2</td>
						<td>메가박스</td>
						<td>8.5</td>
					</tr>
					<tr>
						<td>롯데시네마</td>
						<td>7.2</td>
						<td>우리 평쩜</td>
						<td>8.5</td>
					</tr>
				</table>

				<!---- 줄거리 ---->
				<div class="overContSpecSynop">
					<h3>줄거리</h3>
					<br>
					<h4>2년의 세월이 흘렀다. 갑자기 떠난 시즈루(미야자키 아오이). 2년 후 그녀에게서 온 편지를 들고 마코토(타마키
						히로시)는 크리스마스로 들뜬 뉴욕으로 왔다. 그러나 그를 보러 온 건 미유키(쿠로키 메이사)였다. 과연 그녀에겐 무슨 일이 있는
						것일까? 6년 전, 대학 입학식 날. 번잡한 횡단보도를 건너려는 시즈루와 마주친 마코토. "여기선 건널 수 없으니까 저쪽에서 건너는
						게 좋을 거야" 마코토는 조금은 별난 행동을 하는 그녀를 향해 셔터를 누른다. 둘 만의 숲. 늘 약 냄새가 난다고 생각하는 마코토,
						냄새를 잘 못 맡는 시즈루. 둘은 친구가 되고, 매일 캠퍼스 뒷 숲에서 사진을 찍는다. 그러나 시즈루를 여자로 보지 않는 마코토는
						퀸카 미유키를 짝사랑하고 있다. 시즈루는 성숙한 여자가 되기로 결심하는데...</h4>
				</div>

				<!---- 한줄평 목록 ---->
				<div class="overContSpecComment">
					<h3>코멘트</h3>
					<br>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img
								src="${pageContext.request.contextPath}/resources/img/user1.jpg"></a><br>박희본
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<img src="img/star2.jpg">
							<h3>이 영화 재밌게 봤습니다.</h3>
							<h5>2014.06.19</h5>
						</div>
					</div>
					<div class="clear"></div>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img
								src="${pageContext.request.contextPath}/resources/img/user1.jpg"></a><br>박희본
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<img src="img/star2.jpg">
							<h3>이 영화 재밌게 봤습니다.</h3>
							<h5>2014.06.19</h5>
						</div>
					</div>
					<div class="clear"></div>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img
								src="${pageContext.request.contextPath}/resources/img/user1.jpg"></a><br>박희본
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<img src="img/star2.jpg">
							<h3>이 영화 재밌게 봤습니다.</h3>
							<h5>2014.06.19</h5>
						</div>
					</div>
					<div class="clear"></div>


					<!---- 더보기 ---->
					<a href="#" class="commentMore">더보기</a>

				</div>

			</div>

			<!---- clear:both 지우지 말 것. ---->
			<div class="clear"></div>


		</div>

	</div>


	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->

	<!---- 이미지 좌우 슬라이드 PLUG-IN ---->
	<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>

	<!---- 이미지 좌우 슬라이드 ---->
	<script type="text/javascript" language="javascript">
		$(function() {

			//	Variable number of visible items with variable sizes
			$('#foo3').carouFredSel({
				width : 1030,
				height : 480,
				prev : '#prev3',
				next : '#next3',
				auto : false
			});
		});
	</script>

	<!--------- 컨텐츠 롤오버  -------->
	<script type="text/javascript">
		$(function() {
			$(".imgLink").mouseenter(function() {
				$(".innerOver", this).fadeIn();
				$(".innerOver2", this).fadeIn();
			});
			$(".imgLink").mouseleave(function() {
				$(".innerOver").hide();
				$(".innerOver2").hide();
			});
		});
	</script>

	<!--------- 모달윈도우 : 컨텐츠 상세 -------->
	<script type="text/javascript">
		$(function() {
			$("#glayLayer").click(function() {
				$(this).hide()
				$("#overLayer").hide();
			});

			$("a.imgLink, a.listImgLink").click(function() {
				$("#glayLayer").show();
				$("#overLayer").fadeIn("Fast");
				return false;
			});
			$(".exit").click(function() {
				$("#glayLayer").hide()
				$("#overLayer").hide();
			});

			if ($.browser.msie && $.browser.version < 7) {
				$(window).scroll(
						function() {
							$("#glayLayer").css('top', $(document).scrollTop());
							$("#overLayer").css(
									'top',
									($(document).scrollTop() + $("#overLayer").height() / 2)
											+ "px");
						});
			}
		});
	</script>

 --%>
</body>
</html>
