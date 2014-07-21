<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>

<!-- CSS file -->
<link href="${pageContext.request.contextPath}/resources/css/myroom.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jRating.jquery.css"
	media="screen" />




<article>
	<div class="myPageWrap">
		<div class="title3">




			<div class="myRoomMyFaceWrap">
				<a href="userRoomLink.do?memCD=${member.memCD }" class="myRoomMyFaceLink">
					<img class="myRoomMyFace" src="${member.imgPath}">
				</a>
			</div>
			<p class="myRoomMyFaceP"><strong>${member.memNm}</strong>님이 올린 평점</p>
		</div>
		</div>
		<div class="clear"></div>
		<!---- 한줄평 확인 플로팅 창 ---->
		<div class="overCompleted">
			<p class="overCompletedP"></p>
		</div>


		<div class="postingList">
			<dl>
				<c:forEach items="${postList}" var="post" varStatus="status">

					<dt class="listHead">
						<a class="listWrap">
							<div class="imgWrap" id="imgWrapBook">
								<img class="listImg" src="${post.image}">
							</div>

							<div class="listTable">
								<table>
									<tr>
										<td class="tableTitle">${post.title }</td>
									</tr>
									<tr>
										<td class="tableCont"><img class="myStarPoint"
											src="/pyongjjeom/resources/img/p${post.memGradeChar }.png">
											<p class="myStarPointP">${post.memGradeChar }</p></td>
									</tr>
									<tr>
										<td class="tableCont">${post.comment }</td>
									</tr>
									<tr>
										<td class="tableCont" id="postCD">${post.postCD }</td>
									</tr>
								</table>
							</div>
						</a>
					</dt>


					<dd class="listContent">
						<!---- 댓글 목록 ---->
						<div class="overCont3">

							<div class="overCont3Reply">


							</div>
							<c:choose>
								<c:when test="${member==null}">
									<div c lass="notLoginWrap">
										<a class="notLogin"> <strong>로그인</strong>하시면 댓글을 남길 수
											있습니다.
										</a>
										<div class="loginHidden2">
											<form action="loginsuccess.do" method="post">
												<h2>로그인</h2>
												<table class="loginBox">
													<tr>
														<td class="loginBoxTd1"><label for="email">e-메일</label></td>
														<td class="loginBoxTd2"><input type="text" id="email"
															name="email" placeholder="이메일을...."></td>
													</tr>
													<tr>
														<td class="loginBoxTd1"><label for="password">비밀번호</label></td>
														<td class="loginBoxTd2"><input type="password"
															id="passwd" name="passwd" placeholder="비밀번호..."></td>
													</tr>
												</table>
												<div class="loginButtonWrap">
													<button type="submit" class="loginButton"
														href="loginsuccess.do">로그인</button>
													<button type="button" class="loginButton" id="FBLogin"
														href="loginsuccess.do">페이스북 로그인</button>
												</div>
												<div class="loginElseWrap">
													<a class="loginElse" href="emailAuth.do">비밀번호를 까먹으셧나영?</a><br>
													<a class="loginElse" href="registerMember.do">아직 회원이
														아니신가영?</a>
												</div>
											</form>
										</div>
									</div>

								</c:when>
								<c:otherwise>
									<h3 class="overContTitle">댓글 쓰기</h3>
									<div class="myPointWrap">

										<div class="commentBoxLeft">
											<div class="userPhoto">
												<a href="userRoomLink.do?memCD=${member.memCD }"
													class="userRoomLink"> <img class="userImgPath" src="${member.imgPath }">
												</a>
											</div>
											<div class="commentName">${member.memNm }</div>
										</div>


										<div class="myPoint">
											<textarea class="pointText" placeholder="20자이내로 적어주세요."></textarea>
											<a class="replyUpload">올리기</a>
											<p class="starPoint"></p>
											<p class="myPostCD"></p>
										</div>
									</div>
									<div class="clear"></div>
								</c:otherwise>
							</c:choose>


						</div>

					</dd>
				</c:forEach>

			</dl>
		</div>
</article>





<!-- jQuery files -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jRating.jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jqueryMyRoom.js"></script>


</body>
</html>
