<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>

<!-- CSS file -->
<link href="${pageContext.request.contextPath}/resources/css/myroom.css"	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jRating.jquery.css" media="screen" />




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
						<div class="overCont3"></div>


					</dd>
				</c:forEach>

			</dl>
		</div>
</article>





<!-- jQuery files -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jRating.jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryMyRoom.js"></script>
 
 
</body>
</html>
