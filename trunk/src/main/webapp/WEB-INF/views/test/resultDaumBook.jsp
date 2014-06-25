<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style>
#main {
	background-color: #FAF4C0;
	border-top: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #333333;
	border-right: 1px solid #333333;
}
</style>
</head>
<body>
	<c:forEach var="book" items="${resultList }" varStatus="status">
	<div id="main" onclick="document.location='test1.do?num=${status.index}' ">
		<table border="0">
			<tr>
				<td>제목</td>
				<td><a href="${book.link}">${book.title}</a></td>
			</tr>
			<tr>
				<td>표지이미지</td>
				<td><img src="${book.cover_s_url}"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${book.author }</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>${book.pub_nm }</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>${book.category }</td>
			</tr>
		</table>
				</div>
		<br>
		<br>
	</c:forEach>

</body>
</html>
