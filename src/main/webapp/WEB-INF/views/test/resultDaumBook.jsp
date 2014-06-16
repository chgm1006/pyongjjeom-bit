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
	<c:forEach var="book" items="${resultList }" varStatus="status">
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
				<td>표지이미지</td>
				<td><img src="${book.cover_l_url}"></td>
			</tr>
			<tr>
				<td>설명</td>
				<td>${book.description }</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${book.author }</td>
			</tr>
			<tr>
				<td>역자</td>
				<td>${book.translator }</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>${book.pub_nm }</td>
			</tr>
			<tr>
				<td>출판일</td>
				<td>${book.pub_date }</td>
			</tr>

			<tr>
				<td>카테고리</td>
				<td>${book.category }</td>
			</tr>

			<tr>
				<td>ISBN</td>
				<td>${book.isbn  }</td>
			</tr>

			<tr>
				<td>ISBN13</td>
				<td>${book.isbn13  }</td>
			</tr>

			<tr>
				<td>판매여부</td>
				<td>${book.sale_yn  }</td>
			</tr>

			<tr>
				<td>원가격</td>
				<td>${book.list_price  }</td>
			</tr>
			<tr>
				<td>판매가격</td>
				<td>${book.sale_price  }</td>
			</tr>
			<tr>
				<td>책의 현재 상태</td>
				<td>${book.status_des  }</td>
			</tr>
			<tr>
				<td>바코드 정보</td>
				<td>${book.barcode   }</td>
			</tr>
			<tr>
				<td>E북 바코드 정보</td>
				<td>${book.ebook_barcode   }</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</html>
