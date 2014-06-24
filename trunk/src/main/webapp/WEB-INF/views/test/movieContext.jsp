<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 상세 page</title>
</head>
<body>
	영화 제목 : ${movie.title}
 <br> 
[네이버: ${grades.naverMg}] / [다음: ${grades.daumMg}] / [CGV : ${grades.cgvMg}]/ [LOTTE : ${grades.lotteMg}] / [MEGABOX : ${grades.megaBoxMg}] / [평균 :${avg}]<br>
 <br>
 줄거리 : ${movie.story }<br>
 예고편 : ${movie.trailer }<br>
 감독 : ${movie.director }<br>
 배우 : ${movie.actor }<br>
 국가 : ${movie.nation}<br>
 장르 : ${movie.genre}<br>
 개봉일 : ${movie.open_info}<br>
 홈페이지 : ${movie.homepage}<br>
 비디오 정보 : ${movie.video_info }<br>
 비디오 : ${movie.video}<br>
 포토 정보 : ${movie.photo_info }<br>
 포토 : <img src="${movie.photo1 }"> <img  src="${movie.photo2 }"><img src="${movie.photo3 }"><img src="${movie.photo4}"><img  src="${movie.photo5}"><br>
 평점 : ${movie.grades }<br>
 평점 쓰기 : ${movie.write_grades}<br>
 점수1 : ${movie.grade1}<br>
 점수2 : ${movie.grade2 }<br>
 카테고리 : ${movie.category }<br>
 뉴스 정보 : ${movie.news_info }<br>
 뉴스 1 : ${movie.news1 }<br>
 이벤트 : ${movie.event }<br>
 연령별 평점 : ${movie.age_grades }<br>
 리뷰 카운트 : ${movie.review_cnt }<br>
 위키 이름 :<a href=" ${movie.wiki_url }"> ${movie.wiki_name }</a><br>
 위키 정보 : ${movie.wiki_info }<br>
 리뷰 : ${movie.review }<br>
   
</body>
</html>