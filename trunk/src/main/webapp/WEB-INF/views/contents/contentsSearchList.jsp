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
					<div class="imgWrap">
						<a class="btnDetail" href="#">
							<img  class="listImg" src="${movie.image}">
							<p class="statusIndex">${status.index}</p>
						</a>
					</div>
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">
									<a class="tableTitleLink" href="#">${movie.title }
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
							<a class="listButton" href="#">예고편보기</a> <a class="listButton" href="#">포토보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		
		
		<c:when test="${category =='book'}">
			<c:forEach var="book" items="${resultList }" varStatus="status">
				<div class="listWrap" onclick="document.location='bookContext.do?num=${status.index}'  ">
					<img  class="listImg" src="${book.image}">
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">${book.title }</td>
							</tr>
							<tr>
								<td class="tableTitle2">저자</td>
								<td class="tableCont">${book.author }</td>
							</tr>
							<tr>
								<td class="tableTitle2">평점</td>
								<td class="tableCont">${movie.userRating }</td>
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
						<a class="overButton" href="${movie.link }" target="_blank">네이버 상세</a>
						<a class="overButton" id="overButtonPreview" href="#preview">예고편보기</a>
						<a class="overButton" href="${movie.link }" target="_blank">포토보기</a>
					</div>
				</div>
			</div>

			<div class="overCont2">
				<!---- 예고편 ---->
				<div id="preview">
					<h3 class="overContTitle">예고편</h3>
					<br>
					<iframe class="previewIframe" src="sample.mov"
					autoplay="false" frameborder='no' scrolling='no' marginwidth='0' marginheight='0' width="512" height="410">
					</iframe>

				</div>
				
				
				
				<!---- 줄거리 ---->
				<div class="overSynopWrap">

					<h3 class="overContTitle">줄거리</h3>
					<br>
					<h4 class="overSynop"></h4>
				</div>
			</div>
			<div class="overCont3">
				<!---- 한줄평 목록 ---->
				<div class="overCommentWrap">
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

</article>


<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/footer.jsp"%>

	
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	

<!--------- Ajax JSoN Movie-------->
<script>
	$(document).ready(function() {

		$(".imgWrap,.tableTitleLink").click(function() {
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
					$(".previewIframe").attr("src",video);


				}
			});
		});
	}); 
</script>

	<!--------- 슬라이드 다운 - 예고편 -------->
<script type="text/javascript">
	$(function() {
		$("#overButtonPreview").click(function() {
			if ($("#preview").css("display") == "block") {
				$("#preview:not(:animated)").slideUp("slow");
			} else {
				$("#preview").slideDown("slow");
			}
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

			$(".imgWrap,.tableTitleLink").click(function() {
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
