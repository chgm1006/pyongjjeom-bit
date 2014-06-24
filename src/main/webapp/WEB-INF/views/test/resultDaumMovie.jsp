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
		<div id="main" onclick="document.location='test.do?num=${status.index}' ">
			제목 : ${movie.title} <br> 
			포스터 : <img alt="표지이미지" src="${movie.thumbnail}"><br> 
			감독:${movie.director }<br> 
			 배우:${movie.actor }<br>
		</div>
		<br>
		<br>
	</c:forEach>


</body>
</html>
