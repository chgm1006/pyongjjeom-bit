<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
</head>
<body>






	<table width="100%" cellpadding="0" cellspacing="0" border="1">
		<tr height="5">
			<td width="5"></td>
		</tr>
		<tr style="background: url('img/table_mid.gif') repeat-x; text-align: center;">
			<td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
			<td width="73">번호</td>
			<td width="379">제목</td>
			<td width="73">작성자</td>
			<td width="164">작성일</td>
			<td width="58">조회수</td>
			<td width="7"><img src="img/table_right.gif" width="5" height="30" /></td>
		</tr>
		<tr height="25" align="center">
		</tr>
		<tr height="1" bgcolor="#D2D2D2">
			<td colspan="6"></td>
		</tr>

		<tr height="1" bgcolor="#82B5DF">
			<td colspan="6" width="752"></td>
		</tr>
	</table>
	<table border="1">
		<c:forEach var="notice" items="${add}" varStatus="cnt">
			<tr>
			<td></td>
				<td width="5">${cnt.count }</td>
				<td width="379">${notice.title}</td>
				<td width="73">${notice.person}</td>
				<td width="164">${notice.issue}</td>
				<td width="58">${notice.regidate}</td>
				<td width="58">${notice.updatedate}</td>
			</tr>
			<br>
		</c:forEach>
	</table>






	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td colspan="4" height="5"></td>
		</tr>
		<tr align="center">
			<td><input type=button value="글쓰기" OnClick="window.location='write.do'"></td>
		</tr>
	</table>
</body>
</html>