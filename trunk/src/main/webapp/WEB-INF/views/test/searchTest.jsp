<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div div id="main" >
	영화 제목 : ${movie.title}<br><br>
		부제 : ${movie.subtitle}<br> <br>
	  평점 :	[네이버: ${grades.naverMg}] / [다음: ${grades.daumMg}] / [CGV : ${grades.cgvMg}]/ [LOTTE : ${grades.lotteMg}] / [MEGABOX : ${grades.megaBoxMg}] / [평균 :${avg}]<br><br>
	  <a	href="${movie.link }"> <img src="${movie.image}"></a><br> <br>
		감독 :	${movie.director }<br> <br>
		배우 : ${movie.actor }<br> <br>
		개봉일	:${movie.pubDate}<br><br>
	 장르: ${genre }<br><br>
	 국가: ${nation }<br><br>
	 개봉일: ${open }<br><br>
	 등급: ${grade }<br><br>
	 줄거리: ${context }<br><br>
	 관람객수:${count }<br><br>

   </div>
 	
</body>
</html>