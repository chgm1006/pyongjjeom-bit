<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	