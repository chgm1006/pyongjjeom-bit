<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="movie" items="${resultList }" varStatus="status">
		<table border="0">
			<tr>
				<td>제목</td>
				<td>${movie.title}</td>
			</tr>
			<tr>
				<td>표지 이미지</td>
				<td><img alt="표지이미지" src="${movie.thumbnail}"></td>
			</tr>


		</table>
		<br>
	</c:forEach>

</body>
</html>
