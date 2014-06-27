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
	<div id="main" align="center">
		책 제목 : ${book.title}<br> <br> 
		<a href="${book.link }"> <img src="${book.image}"></a><br> <br> 
		저자 :${book.author }<br><br> 
		 출판사 :${book.publisher}<br> <br> 
		 출간일 :${book.pubdate}<br> <br> 
<%-- 		 정가 :	${book.price }<br> 
		 할인 가격 :${book.discount}<br> 
		 ISBN :${book.isbn}<br>
		내용 :${book.description}<br> --%>

	</div>
	<div>

		<form action="postingInsert.do" method="post">
			<table border="0" width="90%" align="center">
				<tr>
					<td align="center">글내용</td>
					<td><textarea name="postContext"
							style="resize: none; width: 90%; height: 400px" placeholder="후기를 입력하세요."></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2" align="right"><input type="submit"
						value="작성완료"> <input type="button" value="취소"
						onclick="document.location='../search2.jsp'"></td>
				</tr>

			</table>
		</form>
	</div>
	<br>
</body>
</html>