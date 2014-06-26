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
<div div id="main"  align="center">
	영화 제목 : ${movie.title}<br> <br>
		부제 : ${movie.subtitle}<br>  <br>
	  <a	href="${movie.link }"> <img src="${movie.image}"></a><br>  <br>
		감독 :	${movie.director }<br>  <br>
		배우 : ${movie.actor }<br>  <br>
	개봉일	:${movie.pubDate}<br> <br>
<%-- 	
	 네이버 평점 :${movie.userRating}<br> <br>
 --%>
    </div>
 	<div>
		<form action="postingWrite.do" method="post">
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