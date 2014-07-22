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
											<a class="loginElse" href="emailAuth.do">비밀번호를 잊어버리셨나요?</a><br>
											<a class="loginElse" href="registerMember.do">아직 회원이 아니신가요?</a>
										</div>
									</form>
							</div>
						</div>
						
					</c:when>
					<c:otherwise>
						<div class="myPointWrap">
						
							<div class="myStarPoint">
								<div class="myStarPoint1">
									<img class="myStarPointCompleted" src="">
								</div>
								<div class="myStarPoint2">
									<div class="basic" data-average="5" data-id="1">
										<input id="starGrade" type="hidden" name="starGrade" />
									</div>
								</div>
							</div>
							
							<div id="myPoint">
								<textarea class="pointText" placeholder="100자 이내로 작성해 주세요."></textarea>
								<a class="pointSubmit">완료</a>
								<div class="pointModifyWrap">
									<a class="pointModify">수정</a>
									<a class="pointDelete">삭제</a>
								</div>
								<p class="myPostCD"></p>
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

	