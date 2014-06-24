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
<title>포스팅 page</title>
</head>
<body>
<div  id="main"  align="center">
	영화 제목 : ${movie.title}<br>
		부제 : ${movie.subtitle}<br> 
	  <a	href="${movie.link }"> <img src="${movie.image}"></a><br> 
		감독 :	${movie.director }<br> 
		배우 : ${movie.actor }<br> 
		개봉일	:${movie.pubDate}<br>
	 평점 :${movie.userRating}<br>
   </div>
   <br>
   <br>
<div id="main">   
   후기 :${posting }
	</div>
</body>
</html>