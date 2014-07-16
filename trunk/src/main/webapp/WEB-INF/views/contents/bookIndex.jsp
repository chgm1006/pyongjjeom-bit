<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/imageSliderBook.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindowBook.css"
	rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>



<article>
<!-- ########################################### -->
<!-- #################  Top으로 이동  ################# -->
<!-- ########################################### -->
		<a  id="quick" href="article" data-scroll>
			<img class="quickImg" src="${pageContext.request.contextPath}/resources/img/forTop1.png">
		</a>
	
<!-- ########################################### -->
<!-- #################  book 슬라이드 시작  ################# -->
<!-- ########################################### -->

	<div class="wrapper">
        	<div class="title1">베스트 셀러
        	
                </div>
        	<div class="arrow1"> 
                	<a id="prev3" class="prev" href="#"></a> 
                </div>
		
		<div class="list_carousel">
			<ul id="foo3">
                         	<c:forEach  varStatus="count" begin="0" end="${size }">
					<li>
                         <div class="set01">
                         				<c:forEach var="book" items="${bookList }" varStatus="status" begin="${count.index*10}" end="${count.index*10+9}">
                                        	<a class="imgLink" href="#">
                                                <div class="inner">
                                        		<img class="imgList" src="${book.image}" />
                                                        <div class="innerOver2"></div>  
                                                        <div class="innerOver"><p class="statusIndex">${status.index }</p>
                                                                <b>${book.title}</b><br>
                                                                ${book.author}<br>
                                                        </div>  
                                                </div>                                                      
                                                </a>
                                                                </c:forEach>
                                        </div>                        		
                	</li>         
                                                  </c:forEach>
			</ul>
		</div>
                <div class="arrow2"> 
                	<a id="next3" class="next" href="#"></a> 
                </div>
	</div>

		<!-- ########################################### -->
		<!-- #################  하단 리스트 시작  ################# -->
		<!-- ########################################### -->
		<div class="contentsList">
			<div class="title2">최신 도서 리스트</div>

				<c:forEach var="book" items="${bookList }" varStatus="status">
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

		
			
			<!------------------- 더보기 버튼 -------------------->
			<a href="#" class="listMore">더보기</a>
			<!------------------- scroll Top 버튼 -------------------->
			<a href="article" data-scroll><h1>Top</h1></a>
			
		</div>
	
</article>

	<!-- ########################################### -->
	<!-- #################    FOOTER    ################# -->
	<!-- ########################################### -->

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>

	<!-- ################################################# -->
	<!-- #################    모달윈도우 : 도서상세    ################# -->
	<!-- ################################################# -->

	<!---- 검은 바탕 ---->
	<div id='glayLayerBook'></div>

	<!---- above page 시작 ---->
	<div id='overLayerBook'>

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
							<td class="overTableBookTitle" colspan="2"></td>
						</tr>
						<tr>
							<td class="overTableTitle">저자</td>
							<td class="overTableAuthor"></td>
						</tr>
						<tr>
							<td class="overTableTitle">출판사</td>
							<td class="overTablePublisher"></td>
						</tr>
						<tr>
							<td class="overTableTitle">출간일</td>
							<td class="overTablePubdate"></td>
						</tr>
						<tr>
							<td class="overTableTitle">정가</td>
							<td class="overTablePrice"></td>
						</tr>
					</table>

					<table class="overContTable2">
						<tr>
							<td class="overTableTitle2">네이버 평점</td>
							<td class="overTableNaver">0</td>
							<td class="overTableTitle2">Yes24</td>
							<td class="overTableYes24">0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">알라딘</td>
							<td class="overTableAladin">0</td>
							<td class="overTableTitle2">반디앤루니스</td>
							<td class="overTableBandi">0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">교보문고</td>
							<td class="overTableKyobo">0</td>
							<td class="overTableTitle2">평쩜닷컴</td>
							<td class="overTableWoori">0</td>
						</tr>
					</table><br>
					<div class="overButtonWrap">
						<a class="overButton" id="overButtonBookLink" href="${movie.link }" target="_blank">네이버 상세</a>
						<a class="overButton" id="overButtonBookBuy" href="www.kyobobook.co.kr" target="_blank">사러가기</a>
					</div>
				</div>
			</div>

			<div class="overCont2">

				<!---- 저자소개 ---->
				<div class="overAuthorInfoWrap">

					<h3 class="overContTitle">저자소개</h3>
					<h4 class="overAuthorInfo"></h4>
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
						<h3 class="userComment">이 영화 재밌게 봤습니다 여기는 북 모달 book.</h3>
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


	

			<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
			<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>

	<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jqueryBookIndex.js"></script>
		
</body>


</body>
</html>
