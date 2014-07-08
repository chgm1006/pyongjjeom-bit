<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


	<c:choose>
		<c:when test="${category =='movie'}">


			<div div id="main" align="center">
				영화 제목 : ${movie.title}<br> <br> 부제 : ${movie.subtitle}<br> <br>
				<a href="${movie.link }"> <img src="${movie.image}"></a><br> <br>
				감독 : ${movie.director }<br> <br> 배우 : ${movie.actor }<br> <br>
				개봉일 :${movie.pubDate}<br> <br>
				<%-- 	
	 네이버 평점 :${movie.userRating}<br> <br>
 --%>
 
 
 <div class="upLoadCont">
		<form name = updateWrite  id =updateWrite action="updatePostOk.do" method="post">
		<input type="hidden"  value="${book.isbn}"  name="ISBN">
					
					<table border="0" width="90%" align="center">
					<input type="hidden" name="postCD" value="${np.postCD}">
				<tr>
					<td>나의 평점</td>
					<td><input id="range" type="range" value="0" min="0" step="0.5"
						max="10" list="number" onchange="valueChange();" /> <datalist id="number">
							<option>0</option>
							<option>2</option>
							<option>4</option>
							<option>6</option>
							<option>8</option>
							<option>10</option>
						</datalist> <input id="inputValue" type="text" size="5"  name="memGrade"  /></td>
				</tr>
				<tr>
					<td>나의 한줄평</td>
					<td><input type="text" style="width: 90%" name="comment"  value = "${np.comment}"></td>
				</tr>
				<tr>
					<td>나의 후기</td>
					<td><textarea name="review"
							style="resize: none; width: 90%; height: 400px">${np.review}</textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2" align="right"><input type="submit"
						value="작성완료"> <input type="button" value="취소"
						onclick="document.location='../search2.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>
			</div>
		</c:when>

		<c:otherwise>


			<div id="main" align="center">
				책 제목 : ${np.title}   <br> <br> <a href="${np.link }" > <img
					src="${np.image}"></a><br> <br> 저자 :${np.director}<br>
				
				<br>
				<%-- 		 정가 :	${book.price }<br> 
		 할인 가격 :${book.discount}<br> 
		 ISBN :${book.isbn}<br>
		내용 :${book.description}<br> --%>
			</div>
			
			<div class="upLoadCont">
		
		<form action="updatePostOk.do" method="post">
		
		<input type="hidden"  value="${member.memCD}"  name="pmemCD">
		<input type="hidden"  value="${book.title}"  name="title">
		<input type="hidden"  value="${book.link}"  name="link">
	  <input type="hidden"  value="${book.image}"  name="image">
		<input type="hidden"  value="${book.author}"  name="director">
								
					<table border="0" width="90%" align="center">
						<input type="hidden" name="postCD" value="${np.postCD}">
				<tr>
					<td>나의 평점</td>
					<td><input id="range" type="range" value="0" min="0" step="0.5"
						max="10" list="number" onchange="valueChange();"  /> <datalist id="number">
							<option>0</option>
							<option>2</option>
							<option>4</option>
							<option>6</option>
							<option>8</option>
							<option>10</option>
						</datalist> <input id="inputValue" type="text" size="5"  name="memGrade" value = "${np.memGrade}" /></td>
				</tr>
				<tr>
					<td>나의 한줄평</td>
					<td><input type="text" style="width: 90%" name="comment" value="${np.comment}" ></td>
				</tr>
				<tr>
					<td>나의 후기</td>
					<td><textarea name="review"
							style="resize: none; width: 90%; height: 400px" >${np.review}</textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2" align="right"><input type="submit"
						value="작성완료" > <input type="button" value="취소"
						onclick="document.location='../search2.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>
		</c:otherwise>
	</c:choose>

	
	<br>
</body>
</html>