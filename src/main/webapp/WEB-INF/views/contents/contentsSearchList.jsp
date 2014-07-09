<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>


<!---- CSS  ---->
<link href="${pageContext.request.contextPath}/resources/css/contentsList.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/modalWindow.css"
	rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


<article>

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
							<a class="listButton" href="#">예고편보기</a> <a class="listButton" href="#">포토보기</a>
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
							<h1 class="avgPoint">9.9</h1>
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
							<h1 class="avgPoint">9.9</h1>
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
							<td class="overTableNaver">0.0</td>
							<td class="overTableTitle2">Yes24</td>
							<td class="overTableYes24">0.0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">알라딘</td>
							<td class="overTableAladin">0.0</td>
							<td class="overTableTitle2">반디앤루니스</td>
							<td class="overTableBandi">0.0</td>
						</tr>
						<tr>
							<td class="overTableTitle2">교보문고</td>
							<td class="overTableKyobo">0.0</td>
							<td class="overTableTitle2">평쩜닷컴</td>
							<td class="overTableWoori">0.0</td>
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



</article>



	<!-- ########################################### -->
	<!-- #################    FOOTER    ################# -->
	<!-- ########################################### -->

<!-- /// <footer> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>


	
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
<!---- ScrollTop button PLUG-IN ---->
<script type="text/javascript" language="javascript"
		src="${pageContext.request.contextPath}/resources/js/smooth-scroll.js"></script>
<script type="text/javascript">
    smoothScroll.init();
</script>

	<!--------- 예고편 슬라이드 다운  -------->
	<script type="text/javascript">
		$(function() {
			$("#overButtonPreview").click(function() {
				$(".overPreviewWrap").slideDown();
			});
		});
	</script>


<!--------- 모달윈도우 : 도서 상세 -------->
<script type="text/javascript">
		$(function() {
			$("#glayLayerBook").click(function() {
				$(this).hide()
				$("#overLayerBook").hide();
			});

			$("#imgWrapBook,#tableTitleLinkBook").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayerBook").css('top',$(document).scrollTop() + 400 + "px");
				
				$("#glayLayerBook").show();
				$("#overLayerBook").fadeIn("Fast");
				return false;
			});
			$(".exit").click(function() {
				$("#glayLayerBook").hide()
				$("#overLayerBook").hide();
			});

		});
	</script>


<!--------- Ajax JSoN 영화-------->
<script>
	$(document).ready(function() {

		$("#imgWrapMovie,#tableTitleLinkMovie").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};
			
			$.ajax({
				type : "post",
				url : "movieContextJson.do",
				// 				data : formData,
 				async : false,
				data : JSON.stringify(formData),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				beforeSend : function() {
					console.log(formData);
				},
				error : function(e) {
					console.log(e.responseText);
				},
				success : function(data) {
					
					var genre = data.whole.contentMovieDetail.genre;
					var nation = data.whole.contentMovieDetail.nation;
					var open = data.whole.contentMovieDetail.open;
					var grade = data.whole.contentMovieDetail.grade;
					var count = data.whole.contentMovieDetail.count;
					var context = data.whole.contentMovieDetail.context;
					var grades = data.whole.contentMovieDetail.grades;
					var video = data.whole.contentMovieDetail.video;
					
					
					var poster = data.whole.contentMovieDetail.poster;
					
					var title = data.movie.title;
					var link = data.movie.link;
					var subtitle = data.movie.subtitle;
					var pubDate = data.movie.pubDate;
					var director = data.movie.director;
					var actor = data.movie.actor;
					var userRating = data.movie.userRating;
					
					var naverMg = data.whole.grades.naverMg;
					var daumMg = data.whole.grades.daumMg;
					var cgvMg = data.whole.grades.cgvMg;
					var lotteMg = data.whole.grades.lotteMg;
					var megaBoxMg = data.whole.grades.megaBoxMg;

					$(".bigPoster").attr("src",poster);
					$(".smallPoster").attr("src",poster);
					
					if(poster==null||poster==""){
						$(".bigPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
						$(".smallPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
					}
					
					$(".overTableMovieTitle").text(title + " " +pubDate);
					$(".overTableSubtitle").text(subtitle +"  "+ genre +" | "+ nation +" | "+ open);
					$(".overTableDirector").text(director);
					$(".overTableActor").text(actor);
					
					$(".overTableNaver").text(userRating);
					$(".overTableDaum").text(daumMg);
					$(".overTableCGV").text(cgvMg);
					$(".overTableMega").text(megaBoxMg);
					$(".overTableLotte").text(lotteMg);

					$(".overSynop").text(context);
					$("#overButtonLink").attr("href",link);
					
					$("#overButtonPreview").click(function() {
						$(".previewIframe").attr("src",video);

							});
					$("#glayLayer,.exit").click(function() {
						$(".previewIframe").attr("src","");

							});


				}
			});
			
		});

	}); 
</script>

<!--------- Ajax JSoN 도서-------->
<script>
	$(document).ready(function() {

		$("#imgWrapBook,#tableTitleLinkBook").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};

			$
			.ajax({
				type : "post",
				url : "bookContextJson.do",
				// 				data : formData,
				async : false,
				data : JSON.stringify(formData),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				beforeSend : function() {
					console.log(formData);
				},
				error : function(e) {
					console.log(e.responseText);

	},
				
	success : function(data) {

															var title = data.book.title;

															var link = data.book.link;
															var image = data.book.image;
															var author = data.book.author;
															var price = data.book.price;
															var discount = data.book.discount;
															var publisher = data.book.publisher;
															var pubdate = data.book.pubdate;
															var isbn = data.book.isbn;
															var description = data.book.description;

															var naverBg = data.whole.grades.naverBg;
															var yesBg = data.whole.grades.yesBg;
															var aladinBg = data.whole.grades.aladinBg;
															var bandiBg = data.whole.grades.bandiBg;
															var kyoboBg = data.whole.grades.kyoboBg;
															var avg = data.whole.grades.avg;

															var authorIntroContent = data.whole.contentBookDetail.authorIntroContent;
															var bookIntroContent = data.whole.contentBookDetail.bookIntroContent;
															var poster = data.whole.contentBookDetail.poster;


															$(".bigPoster").attr("src",poster);
															$(".smallPoster").attr("src",poster);

															if(poster==null||poster==""){
																$(".bigPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
																$(".smallPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
															}
															

															

															$(".overTableBookTitle").text(title);
															$(".overTableAuthor").text(author);
															$(".overTablePublisher").text(publisher);
															$(".overTablePubdate").text(pubdate);
															$(".overTablePrice").text(price);


															$(".overTableNaver").text(naverBg);
															$(".overTableYes24").text(yesBg);
															$(".overTableAladin").text(aladinBg);
															$(".overTableBandi").text(bandiBg);
															$(".overTableKyobo").text(kyoboBg);

															$(".overAuthorInfo").text(authorIntroContent);
															$(".overSynop").text(bookIntroContent);

															$("#overButtonBookLink").attr("href",link);
															
															
															
														}
													});
										});
					});
</script>



<!--------- 모달윈도우 : 영화 상세 -------->
<script type="text/javascript">
		$(function() {
			$("#glayLayer").click(function() {
				$(this).hide()
				$("#overLayer").hide();
				$(".overPreviewWrap").css("display","none");
			});

			$("#imgWrapMovie,#tableTitleLinkMovie").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayer").css('top',$(document).scrollTop() + 400 + "px");
				
				$("#glayLayer").show();
				$("#overLayer").fadeIn("Fast");
				return false;
			});
			$(".exit").click(function() {
				$("#glayLayer").hide()
				$("#overLayer").hide();
			});

		});
	</script>


</body>
</html>
