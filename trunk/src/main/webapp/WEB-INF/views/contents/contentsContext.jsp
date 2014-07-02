<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#main {
	background-color: #FAF4C0;
	border-top: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #333333;
	border-right: 1px solid #333333;
}
</style>
<title>영화 상세 page</title>
</head>
<body>
<c:choose>
			<c:when test ="${category =='movie'}">
			<div  id="main" >
	영화 제목 : ${movie.title}<br><br>
		부제 : ${movie.subtitle}<br> <br>
			 예고편<br>
	 	 <iframe src="${video}"  width="100%" height="480" frameborder="0" scrolling="no"></iframe>
	  <a	href="${movie.link }"> <img src="${movie.image}"></a><br> <br>
	    <a	href="${movie.link }"> <img src="${poster}"></a><br> <br>
	    	    <a	href="${movie.link }"> <img src="${movie.poster}"></a><br> <br>
	  평점 :	[네이버: ${grades.naverMg}] / [다음: ${grades.daumMg}] / [CGV : ${grades.cgvMg}]/ [LOTTE : ${grades.lotteMg}] / [MEGABOX : ${grades.megaBoxMg}] / [평균 :${avg}]<br><br>
		감독 :	${movie.director }<br> <br>
		배우 : ${movie.actor }<br> <br>
		개봉일	:${movie.pubDate}<br><br>
	 장르: ${genre }<br><br>
	 국가: ${nation }<br><br>
	 개봉일: ${open }<br><br>
	 등급: ${grade }<br><br>
	 줄거리<br>
	  ${context }<br><br>
	 관람객수<br>
	 ${count }<br><br>
	 <br><br>
   </div>
			</c:when>
			<c:otherwise>
			<div  id="main" >
책 제목 : ${book.title}<br> <br>
		<a href="${book.link }"> <img src="${book.image}"></a><br>  <br>
				<a href="${book.link }"> <img src="${poster}"></a><br>  <br>
[네이버: ${grades.naverBg}] / [알라딘: ${grades.aladinBg}] / [반디앤루니스 : ${grades.bandiBg}]/ [교보 : ${grades.kyoboBg}] / [Yes24 : ${grades.yesBg}] / [평균 :${avg}]<br> <br>
		 저자 :${book.author }<br> <br>
		 정가 : ${book.price }<br>  <br>
		할인 가격 :${book.discount}<br> <br>
    출판사 :${book.publisher}<br> <br>
	 	 출간일 :${book.pubdate}<br> <br>
	 	 ISBN :${book.isbn}<br> <br>
	 	 내용 :${book.description}<br> <br>
	 	 책 소개 <br>
	 	  ${bookIntroContent }<br> <br>
	 	 저자 소개 <br>
	 	 ${authorIntroContent } <br> <br>
   </div>
			</c:otherwise>
			</c:choose>
</body>
</html>