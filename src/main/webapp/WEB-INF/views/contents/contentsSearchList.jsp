<%@page import="org.apache.ibatis.executor.ReuseExecutor"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#main {
	background-color: #FAF4C0;
	border-top: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #333333;
	border-right: 1px solid #333333;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/FBscript.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/json2.js"></script>

<script>
	$(document).ready(function() {

		// 		$("#FBLogin").click(function() {
		// 			fnLoginFB();
		// 		});

		$("#main").click(function() {
			var formData = {
				name : "끝까지 간다",
				data : "Hello"
			};
			
			$.ajax({
				type : "post",
				url : "movieContextJson1.do",
				// 				data : formData,
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
					var obj = JSON.parse(data);
// 					alert(data);
// 					alert(data.list);
					console.log(data.title);
					console.log(obj.grades);
// 					console.log(data.name);
// 					console.log(data.msg);
					$.each(data, function(key, val) {
						console.log("Key: " + key + ", val: " + val);
					});

				}
			});
		});
		
		
		$("#main").click(function() {
			
			alert("abc");
			$("#nana").append("<p>789</p>");
			
		});
	});
</script>

</head>
<body>
<div id="nana">이곳에 출력</div>

		<div class="contentsList">
			<div class="title2">검색 결과</div>

			<c:forEach var="movie" items="${movieList }" varStatus="status">
				<div class="listWrap" onclick="document.location='currentMovieContext.do?num=${status.index}' ">
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
			<!------------------- 더보기 버튼 -------------------->
			<a href="#" class="listMore">더보기</a>
		</div>





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
	</c:choose>
</body>
</html>
