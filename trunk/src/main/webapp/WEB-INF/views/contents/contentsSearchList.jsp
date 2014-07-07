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
			<img class="img5" src="${pageContext.request.contextPath}/resources/img/06.jpg">
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
						<td><h1 class="title5"></h1></td>
					</tr>
					<tr>
						<td><h3>감독</h3></td>
						<td><h3></h3></td>
					</tr>
					<tr>
						<td><h3>출연</h3></td>
						<td><h3></h3></td>
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
					
				
					<h3 class="abc">줄거리</h3>
					<br>
					<div id="nana">출력</div>
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


					$("#nana").append("장르 : " + genre + '<br>');
					$("#nana").append("국가 : " + nation + '<br>');
					$("#nana").append("오픈 : " + open + '<br>');
					$("#nana").append("등급 : " + grade + '<br>');
					$("#nana").append("관람객 : " + count + '<br>');
					$("#nana").append("줄거리 : " + context + '<br>');
					$("#nana").append("그레이드 : " + grades + '<br>');
					$("#nana").append("비디오 : " + video + '<br>');
					$("#nana").append("포스터 : " + poster + '<br>');
					

					$(".img5").attr("src",poster);
					$(".overContDetailImg").attr("src",poster);


					$("#nana").append("영화명!!! : " + title + '<br>');
					$("#nana").append("상세페이지!!! : " + link + '<br>');
					$("#nana").append("영문제목!!! : " + subtitle + '<br>');
					$("#nana").append("제작연도!!! : " + pubDate + '<br>');
					$("#nana").append("감독!!! : " + director + '<br>');
					$("#nana").append("출연!!! : " + actor + '<br>');
					$("#nana").append("네이버평점!!! : " + userRating + '<br><br><br><br><br>');

					
					$(".title5").text(title);
					$("#nana").append("코드 : " + naverMg + '<br>');
					$("#nana").append("코드 : " + daumMg + '<br>');
					$("#nana").append("코드 : " + cgvMg + '<br>');
					$("#nana").append("코드 : " + lotteMg + '<br>');
					$("#nana").append("코드 : " + megaBoxMg + '<br><br><br><br>');
					

				}
			});
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
