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



<article>
<!-- ########################################### -->
<!-- #################  Top으로 이동  ################# -->
<!-- ########################################### -->
		<a  id="quick" href="article" data-scroll>
			<img class="quickImg" src="">
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
				<c:forEach varStatus="count" begin="0" end="${size }">
					<li>
						<div class="set01">
							<c:forEach var="book" items="${bookList }" varStatus="status"
								begin="${count.index*10}" end="${count.index*10+9}">
								<a class="imgLink" href="#">
									<div class="inner">
										<img class="imgList" src="${book.image}" />
										<div class="innerOver2"></div>
										<div class="innerOver">
											<p class="statusIndex">${status.index }</p>
											<b>${book.title}</b><br> ${book.author}<br>
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

<!-- /// 모달윈도우 INCLUDE /// -->
<%@ include file="../common/modalBookIndex.jsp"%>



<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>

<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>

<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/jqueryBookIndex.js"></script>
		

</body>
</html>
