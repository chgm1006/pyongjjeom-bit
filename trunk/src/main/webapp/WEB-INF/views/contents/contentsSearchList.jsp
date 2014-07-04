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


<div id="nana">이곳에 출력</div>

		<div class="contentsList">
			<div class="title2">검색 결과</div>
	<c:choose>
		<c:when test="${category =='movie'}">
			<c:forEach var="movie" items="${resultList }" varStatus="status">
				<div class="listWrap" onclick="document.location='movieContext.do?num=${status.index}'  ">
					<img  class="listImg" src="${movie.image}"></a>
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">${movie.title }</td>
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
							<a class="listButton" href="${movie.link }">네이버 상세</a>
							<a class="listButton" href="#">예고편보기</a> <a class="listButton" href="#">포토보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		
		
		
		<c:when test="${category =='book'}">
			<c:forEach var="movie" items="${resultList }" varStatus="status">
				<div class="listWrap" onclick="document.location='bookContext.do?num=${status.index}'  ">
					<img  class="listImg" src="${book.image}"></a>
					<div class="listTable">
						<table>
							<tr>
								<td class="tableTitle" colspan="2">${book.title }</td>
							</tr>
							<tr>
								<td class="tableSubtitle">부제</td>
								<td class="tableCont">${book.subtitle }</td>
							</tr>
							<tr>
								<td class="tableTitle2">감독</td>
								<td class="tableCont">${book.director }</td>
							</tr>
							<tr>
								<td class="tableTitle2">출연</td>
								<td class="tableCont">${book.actor }</td>
							</tr>
							<tr>
								<td class="tableTitle2">개봉년도</td>
								<td class="tableCont">${book.pubDate }</td>
							</tr>

							<tr>
								<td class="tableTitle2">평점</td>
								<td class="tableCont">${book.userRating }</td>
							</tr>
						</table>
						<div class="listButtonWrap">
							<a class="listButton" href="${book.link }">네이버 상세</a>
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




<%-- 
	<c:choose>
		<c:when test="${category =='movie'}">

			<c:forEach var="movie" items="${resultList }" varStatus="status">
				<div id="main" >
					영화 제목 : ${movie.title}<br> <br>부제 : ${movie.subtitle}<br> <br>
					<a href="${movie.link }"> <img src="${movie.image}"></a><br> <br>감독
					: ${movie.director }<br> <br>배우 : ${movie.actor }<br> <br>개봉일
					:${movie.pubDate}<br> <br>평점 :${movie.userRating}<br> <br>
				</div>
				<br>
			</c:forEach>

		</c:when>
		<c:otherwise>
			<c:forEach var="book" items="${resultList }" varStatus="status">
				<div id="main"
					onclick="document.location='bookContext.do?num=${status.index}' ">
					책 제목 : ${book.title}<br> <br> <a href="${book.link }"> <img
						src="${book.image}"></a><br> <br> 저자 :${book.author }<br>
					<br> 출판사 :${book.publisher}<br> <br> 출간일 :${book.pubdate}<br>
					<br> 정가 : ${book.price }<br> <br>
				</div>
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose> --%>
	
	
</body>
</html>
