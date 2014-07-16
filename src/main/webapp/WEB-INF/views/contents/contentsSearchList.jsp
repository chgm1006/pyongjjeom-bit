<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css"
	rel="stylesheet" type="text/css">


<article>
<!-- ########################################### -->
<!-- #################  Top으로 이동  ################# -->
<!-- ########################################### -->
		<a  id="quick" href="article" data-scroll>
			<img class="quickImg" src="${pageContext.request.contextPath}/resources/img/forTop1.png">
		</a>
	
		<div class="contentsList">
			<div class="title3">검색 결과</div>
	<c:choose>
		<c:when test="${category =='movie'}">
			<c:forEach var="movie" items="${resultList }" varStatus="status" >
				<div class="listWrap" >
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
								<td class="tableTitle2">부제</td>
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
							<a class="listButton" href="#">예고편보기</a> <a class="listButton" href="#">포토보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		
		<c:when test="${category =='book'}">
			<c:forEach var="book" items="${resultList }" varStatus="status">
				<div class="listWrap">
					<div class="imgWrap" id="imgWrapBook">
						<a class="btnDetail" href="#">
							<img  class="listImg" src="${book.image}">
							<p class="statusIndex">${status.index}</p>
						</a>
					</div>
					
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">
									<a class="tableTitleLink" id="tableTitleLinkBook" href="#">${book.title }
										<p class="statusIndex">${status.index}</p>
									</a>
								</td>
							</tr>
							<tr>
								<td class="tableTitle2">저자</td>
								<td class="tableCont">${book.author }</td>
							</tr>
							<tr>
								<td class="tableTitle2">출판사</td>
								<td class="tableCont">${book.publisher }</td>
							</tr>
							<tr>
								<td class="tableTitle2">출간일</td>
								<td class="tableCont">${book.pubdate }</td>
							</tr>
							<tr>
								<td class="tableTitle2">책내용</td>
								<td class="tableCont">${book.description }	</td>
							</tr>
						</table>
						<div class="listButtonWrap">
							<a class="listButton" href="${book.link }" target="_blank">네이버 상세</a>
							<a class="listButton" href="www.kyobobook.co.kr">사러가기</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</c:when>
	</c:choose>
		
			
			<!------------------- 더보기 버튼 -------------------->
			<a href="#" class="listMore">더보기</a>
		</div>


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
							<td class="overTableWoori">0.0</td>
						</tr>
					</table><br>
					<div class="overButtonWrap">
						<a class="overButton" id="overButtonLink" href="${movie.link }" target="_blank">네이버 상세</a>
						<a class="overButton" id="overButtonPreview" href="#overButtonPreview" data-scroll>예고편보기</a>
						<a class="overButton" href="${movie.link }" target="_blank">포토보기</a>
						<a class="overButton2" id="overButtonPoint"  href=".overContTable" data-scroll>My 평점</a>
					</div>
				</div>
			</div>

			<div class="overCont2">
				<!---- My 평점 ---->
				<div class="overPointWrap">
					<h3 class="overContTitle">My 평점</h3>				
					<div id="myPoint">
						<form>
							<input type="text" style="width:500px; padding:10px; font-size:20px;">
							<input type="submit" value="완료" style="line-height:20px;">
						</form>
						
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
			</div>
			
			<!---- 코멘트 목록 ---->
			<div class="overCont3">
				<h3 class="overContTitle">코멘트</h3>
					
				<div class="overCommentWrap">
					<div class="commentBoxLeft">
					
						<div class="userPhoto">
							<a href="#" class="userRoomLink">
								<img src="${pageContext.request.contextPath}/resources/img/user1.jpg">
							</a><br>
						</div>
						
						<div class="commentName">박희본
						</div>
					</div>
					
					<div class="commentBoxRight">
						<h3 class="userComment">이 영화 재밌게 봤습니다.</h3>
						<h5 class="userDate">2014.06.19</h5>
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
	</div>



</article>



	<!-- ########################################### -->
	<!-- #################    FOOTER    ################# -->
	<!-- ########################################### -->

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/modalContentsList.jsp"%>
	
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
	<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
		
			<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jqueryContentsSearchList.js"></script>
		

</body>
</html>
