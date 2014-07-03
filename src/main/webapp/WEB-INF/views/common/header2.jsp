<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ########################################### -->
<!-- #################    탑   메  뉴     ################# -->
<!-- ########################################### -->
<header>
	<div class="topMenu">
		<div class="leftMenu">
			<a href="movieIndex.do"><img
				src="${pageContext.request.contextPath}/resources/img/logo.jpg" class="logo" /></a>
			<ul>
				<li class="menu1"><a href="movieIndex.do">영화</a></li>
				<li class="menu2"><a href="bookIndex.do">도서</a></li>
				<li class="menu3"><a href="#">공연</a></li>
			</ul>
			<div class="search">
				<form action="ContentsSearch.do" method="get" id="frmLogin"
					name="frmLogin">
					<select name="category">
						<option value="book">책
						<option value="movie">영화
					</select> <input type="text" id="Search" name="Search"> <input type="hidden"
						name="stat" value="search"> <input type="submit" value="검색">
					<a href="#"> <img class="magnifier"
						src="${pageContext.request.contextPath}/resources/img/magnifier.png">
					</a>
				</form>
			</div>
		</div>


		<div class="rightMenu">
			<ul>
				<c:choose>
					<c:when test="${member==null}">
						<li class="menu5"><a href="login.do" class="menu5_1">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li class="menu5_1"><a href="myRoom.do" class="menu5_1_1">마이룸</a></li>
					</c:otherwise>
				</c:choose>
				<li class="menu6"><a href="#" class="menu6_1">친구들</a></li>
				<li class="menu7"><a href="boardList.do" class="menu7_1">공지사항</a></li>

			</ul>
		</div>
	</div>
</header>

