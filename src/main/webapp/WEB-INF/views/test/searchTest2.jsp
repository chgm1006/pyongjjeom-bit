<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>책 상세 page</title>
</head>
<body>
	<div id="main">

		책 제목 : ${book.title}<br> <br> <a href="${book.link }"> <img src="${book.image}"></a><br> <br>
		[네이버: ${grades.naverBg}] / [알라딘: ${grades.aladinBg}] / [반디앤루니스 : ${grades.bandiBg}]/ [교보 : ${grades.kyoboBg}] / [Yes24
		: ${grades.yesBg}] / [평균 :${avg}]<br> <br> 저자 :${book.author }<br> <br> 정가 : ${book.price }<br>
		<br> 할인 가격 :${book.discount}<br> <br> 출판사 :${book.publisher}<br> <br> 출간일 :${book.pubdate}<br>
		<br> ISBN :${book.isbn}<br> <br> 내용 :${book.description}<br> <br> 책 소개 <br>
		${bookIntroContent }<br> <br> 저자 소개 <br> ${authorIntroContent } <br> <br>


	</div>

</body>
</html>