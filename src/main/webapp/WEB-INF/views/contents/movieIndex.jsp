<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/imageSlider.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jRating.jquery.css" media="screen" />



	<article>

<!-- ########################################### -->
<!-- #################  Top으로 이동  ################# -->
<!-- ########################################### -->
		<a  id="quick" href="article" data-scroll>
			<img class="quickImg" src="${pageContext.request.contextPath}/resources/img/forTop1.png">
		</a>
	
<!-- ########################################### -->
<!-- #################  슬라이드 시작  ################# -->
<!-- ########################################### -->

		<div class="wrapper">
			<div class="title1">현재 상영 영화</div>

			<!---- 왼쪽 화살표 ---->
			<div class="arrow1">
				<a id="prev3" class="prev" href="#"></a>
			</div>

						<div class="list_carousel">
				<ul id="foo3">
					<c:forEach items="${movieList }" var="movie" varStatus="status">
						<li class="liList">
							<a class="imgLink" href="#"> 
								<img class="imgList" src="${movie.poster}" /><p class="statusIndex">${status.index}</p>
								<div class="innerOver2"></div>
								<div class="innerOver">
									<h2>${movie.title }</h2><br> 감독 : ${movie.director}<br> 출연 : ${movie.actor }<br>
								
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
			<div class="title2">최신 영화 리스트</div>

			<c:forEach var="movie" items="${movieList }" varStatus="status">
				<div class="listWrap">
				
					<div class="imgWrap" id="imgWrapMovie">
						<a class="btnDetail" href="#">
							<img  class="listImg" src="${movie.image}">
							<p class="statusIndex">${status.index}</p>
						</a>
					</div>
				
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">
									<a class="tableTitleLink"  id="tableTitleLinkMovie" href="#">${movie.title }
										<p class="statusIndex">${status.index}</p>
									</a>									
								</td>
							</tr>
							<tr>
								<td class="tableSubtitle">부제</td>
								<td class="tableCont">${movie.subtitle }</td>
							</tr>
							<tr>
								<td class="tableTitle2">감독</td>
								<td class="tableCont">${movie.director }</td>
							</tr>
							<tr>
								<td class="tableTitle2">출연</td>
								<td class="tableCont">${movie.actor }</td>
							</tr>
							<tr>
								<td class="tableTitle2">개봉년도</td>
								<td class="tableCont">${movie.pubDate }</td>
							</tr>

							<tr>
								<td class="tableTitle2">평점</td>
								<td class="tableCont">${movie.userRating }</td>
							</tr>
						</table>
						<div class="listButtonWrap">
							<a class="listButton" href="${movie.link }" target="_blank">네이버 상세</a>
							<a class="listButton" href="${movie.link }" target="_blank">예고편보기</a> 
							<a class="listButton" href="${movie.link }" target="_blank">포토보기</a>
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

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>

	<!-- ################################################# -->
	<!-- #################    모달윈도우 : 영화상세    ################# -->
	<!-- ################################################# -->

	<!---- 검은 바탕 ---->
	<div id='glayLayer'></div>

	<!---- above page 시작 ---->
	<div id='overLayer'>

		<!---- 큰 포스터 JPG ---->
		<div class="overTitle">
			<a href="#" class="exit"></a>
			<img class="bigPoster" src="${pageContext.request.contextPath}/resources/img/ready.jpg">
		</div>

		<!---- 작은 포스터 JPG + 평균평점 ---->
		<div class="overCont">
			<div class="smallPosterWrap">
				<img class="smallPoster"
					src="${pageContext.request.contextPath}/resources/img/ready.jpg">
			</div>

			<div class="overCont1">
				<!---- 하단 상세 설명 ---->
				<div class="overContTableWrap">
					<div class="averageWrap">
						<div class="avg1">
							<h1 class="avgPoint">0.0</h1>
						</div>
						<div class="avg2">
							<h4>평균평점</h4>
						</div>
					</div>
					
					<table class="overContTable">
						<tr>
							<td class="overTableMovieTitle" colspan="2"></td>
						</tr>
						<tr>
							<td class="overTableSubtitle" colspan="2"></td>
						</tr>
						<tr>
							<td class="overTableTitle">감독</td>
							<td class="overTableDirector"></td>
						</tr>
						<tr>
							<td class="overTableTitle">출연</td>
							<td class="overTableActor"></td>
						</tr>
					</table>

					<table class="overContTable2">
						<tr>
							<td class="overTableTitle2">네이버 평점</td>
							<td class="overTableNaver">0.0</td>
							<td class="overTableTitle2">다음 평점</td>
							<td class="overTableDaum">0.0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">CGV</td>
							<td class="overTableCGV">0.0</td>
							<td class="overTableTitle2">메가박스</td>
							<td class="overTableMega">0.0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">롯데시네마</td>
							<td class="overTableLotte">0.0</td>
							<td class="overTableTitle2">평쩜닷컴</td>
							<td class="overTableWoori">0</td>
						</tr>
					</table><br>
					<div class="overButtonWrap">
						<a class="overButton" id="overButtonLink" href="${movie.link }" target="_blank">네이버 상세</a>
						<a class="overButton" id="overButtonPreview" href=".overContTable" data-scroll>예고편보기</a>
						<a class="overButton" href="${movie.link }" target="_blank">포토보기</a>
					</div>
				</div>
			</div>

			<div class="overCont2">
				<!---- 예고편 ---->
				<div class="overPreviewWrap">
					<h3 class="overContTitle">예고편</h3>				
					<div id="preview">
						<iframe class="previewIframe" src=""
						autoplay="false" frameborder='no' scrolling='no' marginwidth='0' marginheight='0' width="512" height="410">
						</iframe>
					</div>
				</div>
				
				<!---- 줄거리 ---->
				<div class="overSynopWrap">

					<h3 class="overContTitle">줄거리</h3>
					<h4 class="overSynop"></h4>
				</div>
				
				<!---- My 평점 ---->
				<div class="overPointWrap">
					<h3 class="overContTitle">My 평점</h3>	
				<c:choose>
					<c:when test="${member==null}">
						<div c lass="notLoginWrap"> 
							<a class="notLogin">
								<strong>로그인</strong>하시면 평점을 남길 수 있습니다.
							</a>
							<div class="loginHidden2">
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
											<a class="loginElse" href="emailAuth.do">비밀번호를 까먹으셧나영?</a><br>
											<a class="loginElse" href="registerMember.do">아직 회원이 아니신가영?</a>
										</div>
									</form>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="myPointWrap">
							<div class="myStarPoint">
							별표 그림</div>
							<div class="myPointText">여기는 그냥
							</div>
						</div>
						<div class="myPointModify">
							<div id="myPoint">
								<div class="basic" data-average="5" data-id="1" style="float:left;padding:10px 10px 0 0">
									<input id="memGrade" type="hidden" name="memGrade" />
								</div>
								<textarea class="pointText"  disabled="disabled" style="resize:none; float:left; width:500px; padding:10px; font-size:20px;">
								</textarea>
								<a class="pointSubmit" style="cursor:pointer; line-height:20px;">완료</a>
								<a class="pointModify" style="cursor:pointer; line-height:20px;">수정</a>
								<p class="starPoint" style="display:none;"></p>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			
			</div>
			
			<!---- 코멘트 목록 ---->
			<div class="overCont3">
				
			</div>

			<!---- clear:both 지우지 말 것. ---->
			<div class="clear"></div>

		</div>

	</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scrollBanner2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jRating.jquery.js"></script>

<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>		
<script src="${pageContext.request.contextPath}/resources/js/jqueryMovieIndex.js"></script>

</body>
</html>
