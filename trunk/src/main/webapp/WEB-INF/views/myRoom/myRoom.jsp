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
		<div class="title3">내가 올린 포스트</div>



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
						<div class="overCont3Reply"></div>
						<c:choose>
							<c:when test="${member==null}">
								<div c lass="notLoginWrap">
									<a class="notLogin"> <strong>로그인</strong>하시면 평점을 남길 수 있습니다.
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
								<div class="myPointWrap">

									<div class="myStarPoint">
										<div class="myStarPoint1">
											<img class="myStarPointCompleted" src="">
										</div>
										<div class="myStarPoint2">
											<div class="basic" data-average="5" data-id="1">
												<input id="memGrade" type="hidden" name="memGrade" />
											</div>
										</div>
									</div>

									<div id="myPoint">
										<textarea class="pointText" disabled="disabled"></textarea>
										<a class="pointSubmit">완료</a>
										<div class="pointModifyWrap">
											<a class="pointModify">수정</a> <a class="pointDelete">삭제</a>
										</div>
										<p class="starPoint"></p>
										<p class="myPostCD"></p>
									</div>
								</div>
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
