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
</head>
<body>

	<c:forEach var="movie" items="${resultList }" varStatus="status">
		<div id="main" onclick="document.location='test2.do?num=${status.index}' ">

			영화 제목 : ${movie.title}<br> 부제 : ${movie.subtitle}<br> 포스터 :<a
				href="${movie.link }"> <img src="${movie.image}"></a><br> 감독 :
			${movie.director }<br> 배우 : ${movie.actor }<br> 개봉일
			:${movie.pubDate}<br> 평점 :${movie.userRating}<br>
		</div>
		<br>
	</c:forEach>

</body>
</html>
