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

<!-- /// 모달윈도우JSP  INCLUDE /// -->
<%@ include file="../common/modalMovieIndex.jsp"%>

<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jRating.jquery.js"></script>
<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>		
<script src="${pageContext.request.contextPath}/resources/js/jqueryMovieIndex.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scrollBanner2.js"></script>



</body>
</html>
