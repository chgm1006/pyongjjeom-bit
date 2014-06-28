<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					것일까? 6년 전, 대학 입학식 날. 번잡한 횡단보도를 건너려는 시즈루와 마주친 마코토. "여기선 건널 수 없으니까 저쪽에서 건너는 게
					좋을 거야" 마코토는 조금은 별난 행동을 하는 그녀를 향해 셔터를 누른다. 둘 만의 숲. 늘 약 냄새가 난다고 생각하는 마코토, 냄새를
					잘 못 맡는 시즈루. 둘은 친구가 되고, 매일 캠퍼스 뒷 숲에서 사진을 찍는다. 그러나 시즈루를 여자로 보지 않는 마코토는 퀸카
					미유키를 짝사랑하고 있다. 시즈루는 성숙한 여자가 되기로 결심하는데...</h4>
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

