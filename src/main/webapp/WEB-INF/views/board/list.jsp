<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
</head>
<body>



	<%
		final int ROWSIZE = 4; // 한페이지에 보일 게시물 수
		final int BLOCK = 5; // 아래에 보일 페이지 최대개수 1~5 / 6~10 / 11~15 식으로 5개로 고정

		int pg = 1; //기본 페이지값

		if (request.getParameter("pg") != null) { //받아온 pg값이 있을때, 다른페이지일때
			pg = Integer.parseInt(request.getParameter("pg")); // pg값을 저장
		}

		int start = (pg * ROWSIZE) - (ROWSIZE - 1); // 해당페이지에서 시작번호(step2)
		int end = (pg * ROWSIZE); // 해당페이지에서 끝번호(step2)

		int allPage = 0; // 전체 페이지수

		int startPage = ((pg - 1) / BLOCK * BLOCK) + 1; // 시작블럭숫자 (1~5페이지일경우 1, 6~10일경우 6)
		int endPage = ((pg - 1) / BLOCK * BLOCK) + BLOCK; // 끝 블럭 숫자 (1~5일 경우 5, 6~10일경우 10)
	%>

	%>




	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr height="5">
			<td width="5"></td>
		</tr>
		<tr style="background: url('img/table_mid.gif') repeat-x; text-align: center;">
			<td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
			<td width="73">글번호</td>
			<td width="379">제목</td>
			<td width="73">작성자</td>
			<td width="164">작성일</td>
			<td width="58">최종작성일</td>
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
	<table border="0">
		<c:forEach var="notice" items="${add}" varStatus="cnt">
			<tr>
				<td></td>
				
			<td width="70"></td>
				<td width="373">${cnt.count }</td>
				<td width="379">${notice.title}</td>
				<td width="173">${notice.person}</td>
				<%-- <td width="164">${notice.issue}</td> --%>
				<td width="158">${notice.regidate}</td>
				<td width="158">${notice.updatedate}</td>
			</tr>
			<br>
		</c:forEach>
	</table>



	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td colspan="4" height="200"></td>
		</tr>
		<tr>
			<td align="center">
				<%
					if (pg > BLOCK) {
				%> [<a href="list.jsp?pg=1">◀◀</a>] [<a
				href="list.jsp?pg=<%=startPage - 1%>">◀</a>] <%
					}
				%> <%
 	for (int i = startPage; i <= endPage; i++) {
 		if (i == pg) {
 %> <u><b>[<%=i%>]
				</b></u> <%
 	} else {
 %> [<a href="list.jsp?pg=<%=i%>"><%=i%></a>] <%
 	}
 	}
 %> <%
 	if (endPage < allPage) {
 %> [<a href="list.jsp?pg=<%=endPage + 1%>">▶</a>] [<a
				href="list.jsp?pg=<%=allPage%>">▶▶</a>] <%
 	}
 %>
			</td>
		</tr>



		<tr align="center">
			<td><input type=button value="글쓰기" OnClick="window.location='write.do'"></td>
		</tr>
	</table>
</body>
</html>